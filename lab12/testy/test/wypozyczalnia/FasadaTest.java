/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.util.Arrays;
import java.util.Collection;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

@Category({TestControl.class, TestEntity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FasadaTest {
    static Dane dane = new Dane();
    static Fasada instance = new Fasada();
    
    public FasadaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Parameterized.Parameter(value = 0)
    public int numer1;
    @Parameterized.Parameter(value = 1)
    public int numer2;
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data1 = new Object[][]{
            {0, 0}, {1, 1}, {2, 2}, {3, 3},
            {4, 4}, {5, 5}, {6, 3}, {7, 1}, 
            {8, 0}
        };
        return Arrays.asList(data1);
    }
    

    /**
     * Test of wyszukajGre method, of class Fasada.
     */
    @Test
    public void test1WyszukajGre() {
        System.out.println("wyszukajGre");
        for (int i = 0; i < 6; i++) {
            instance.getGry().add(dane.gry[i]);
            assertNotNull(instance.wyszukajGre(dane.dane_gier[i]));
        }
        instance.getGry().clear();
    }

    /**
     * Test of dodajGre method, of class Fasada.
     */
    @Test
    public void test2DodajGre() {
        System.out.println("dodajGre");
        for (int i = 0; i < 6; i++) {
            instance.dodajGre(dane.dane_gier[i]);
            assertEquals(instance.wyszukajGre(dane.dane_gier[i]), dane.gry[i]);
        }
    }

    /**
     * Test of dodajEgzemplarz method, of class Fasada.
     */
    @Test
    public void test3DodajEgzemplarz() {
        System.out.println("dodajEgzemplarz");
        instance.dodajEgzemplarz(dane.dane_gier[numer2], numer1);
        assertNotNull(instance.wyszukajGre(dane.dane_gier[numer2]).wyszukajEgzemplarz(numer1));
    }    
}
