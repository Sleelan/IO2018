/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class FasadaMockingTest {
    
    public String dane_gier[][] = {
        {"Red Dead Redemption 2", "Rockstar", "2018", "PS4"},
        {"Dark Souls", "From Software", "2014", "PC"},
        {"TES V - Skyrim", "Bethesda", "2012", "PC"},
        {"TES V - Skyrim", "Bethesda", "2012", "PS3"},
        {"Wiedźmin 3: Dziki Gon", "CDProjekt Red", "2015", "PC"},
        {"Dying Light", "Techland", "2015", "PC"}
    };
    
    public Gra gry[] = {
        new Gra(dane_gier[0][0], dane_gier[0][1], Integer.parseInt(dane_gier[0][2]), dane_gier[0][3]),
        new Gra(dane_gier[1][0], dane_gier[1][1], Integer.parseInt(dane_gier[1][2]), dane_gier[1][3]),
        new Gra(dane_gier[2][0], dane_gier[2][1], Integer.parseInt(dane_gier[2][2]), dane_gier[2][3]),
        new Gra(dane_gier[3][0], dane_gier[3][1], Integer.parseInt(dane_gier[3][2]), dane_gier[3][3]),
        new Gra(dane_gier[4][0], dane_gier[4][1], Integer.parseInt(dane_gier[4][2]), dane_gier[4][3]),
        new Gra(dane_gier[5][0], dane_gier[5][1], Integer.parseInt(dane_gier[5][2]), dane_gier[5][3])
    };
    
    @Mocked Fabryka fabryka;
    
    @Test
    public void testDodajGre(){
        System.out.println("dodajGre");
        new Expectations(){
            {
                fabryka.stworzGre(dane_gier[0]); result = gry[0];
                fabryka.stworzGre(dane_gier[1]); result = gry[1];
                fabryka.stworzGre(dane_gier[2]); result = gry[2];
                fabryka.stworzGre(dane_gier[3]); result = gry[3];
                fabryka.stworzGre(dane_gier[4]); result = gry[4];
                fabryka.stworzGre(dane_gier[5]); result = gry[5];
            }
        };
        Fasada fasada = new Fasada();
        for (int i = 0; i < 6; i++) {
            fasada.dodajGre(dane_gier[i]);
            assertEquals(gry[i], fasada.getGry().get(i));
        }
    }
}