/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.experimental.categories.Category;
import org.junit.Test;
import static org.junit.Assert.*;

@Category({TestControl.class, TestEntity.class})
public class FabrykaTest {
    Dane dane = new Dane();
    
    public FabrykaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of stworzGre method, of class Fabryka.
     */
    @Test
    public void testStworzGre() {
        System.out.println("stworzGre");
        Fabryka instance = new Fabryka();
        for (int i = 0; i < 6; i++) {
            Gra result = instance.stworzGre(dane.dane_gier[i]);
            assertEquals(dane.gry[i], result);
        }
        
    }
    
}
