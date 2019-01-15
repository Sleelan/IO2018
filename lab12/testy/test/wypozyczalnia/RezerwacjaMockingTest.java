/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.util.Date;
import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class RezerwacjaMockingTest {
    private Date aktualna_data = new Date();
    private long dzien = 86400000;
    public Date daty[] = {
        new Date(aktualna_data.getTime()+0*dzien),
        new Date(aktualna_data.getTime()+1*dzien),
        new Date(aktualna_data.getTime()+2*dzien),
        new Date(aktualna_data.getTime()+3*dzien),
        new Date(aktualna_data.getTime()+4*dzien),
        new Date(aktualna_data.getTime()+5*dzien),
        new Date(aktualna_data.getTime()+6*dzien)
    };
    
    @Mocked EgzemplarzGry egzemplarz;
    
    @Test
    public void testPrzedloz(){
        System.out.println("przedloz");
        Rezerwacja rezerwacja = new Rezerwacja(egzemplarz, null, daty[1]);
        new Expectations(){
            {
                egzemplarz.czyTerminKolidujeZRezerwacjami((Date) any); 
                returns(false, false, false, true, true, false);
            }
        };
        
        rezerwacja.przedluz(daty[2]); assertEquals(rezerwacja.getDataWygasniecia(), daty[2]);
        rezerwacja.przedluz(daty[4]); assertEquals(rezerwacja.getDataWygasniecia(), daty[4]);
        rezerwacja.przedluz(daty[5]); assertEquals(rezerwacja.getDataWygasniecia(), daty[5]);
        rezerwacja.przedluz(daty[3]); assertNotEquals(rezerwacja.getDataWygasniecia(), daty[3]);
        rezerwacja.przedluz(daty[1]); assertNotEquals(rezerwacja.getDataWygasniecia(), daty[1]);
        rezerwacja.przedluz(daty[6]); assertEquals(rezerwacja.getDataWygasniecia(), daty[6]);
    }
}
