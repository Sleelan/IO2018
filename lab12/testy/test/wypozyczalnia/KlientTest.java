/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.junit.Test;
import static org.junit.Assert.*;

@Category({TestEntity.class})
public class KlientTest {
    Dane dane = new Dane();
    
    public KlientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of przypiszRezerwacje method, of class Klient.
     */
    @Test
    public void testPrzypiszRezerwacje() {
        System.out.println("przypiszRezerwacje");
        for (int i = 0; i < 6; i++) {
            dane.klienci[i].przypiszRezerwacje(dane.rezerwacje[i]);
            Rezerwacja result = dane.klienci[i].wyszukajRezerwacjeNaEgzemplarz(dane.egzemplarze[i]);
            assertTrue(result.equals(dane.rezerwacje[i]));
        }
    }
    
}
