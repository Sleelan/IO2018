/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;

@Category({TestEntity.class})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(Parameterized.class)
public class GraTest {
    static Dane dane = new Dane();
    
    public GraTest() {
    }
    
    @Parameter(value = 0)
    public int numer1;
    @Parameter(value = 1)
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

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of dodajEgzemplarz method, of class Gra.
     */
    @Test
    public void testDodajEgzemplarz() {
        System.out.println("dodajEgzemplarz");
        dane.gry[numer2].dodajEgzemplarz(numer1);
        assertTrue(dane.gry[numer2].getEgzemplarze().contains(dane.egzemplarze[numer1]));
    }

    /**
     * Test of wyszukajEgzemplarz method, of class Gra.
     */
    @Test
    public void testWyszukajEgzemplarz() {
        System.out.println("wyszukajEgzemplarz");
        assertNotNull(dane.gry[numer2].wyszukajEgzemplarz(numer1));
    }
}
