package wypozyczalnia;

import java.util.Arrays;
import java.util.Date;
import mockit.Delegate;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class GraMockingTest {
    
    @Injectable
    EgzemplarzGry egz1, egz2, egz3;
    
    @Test
    public void testZnajdzWolnyEgzemplarz(){
        System.out.println("znajdzWolnyEgzemplarz");
        Gra gra = new Gra("Red Dead Redemption 2", "Rockstar", 2018, "PS4");
        EgzemplarzGry egze[] = {egz1, egz2, egz3};
        Date termin = new Date();
        gra.setEgzemplarze(Arrays.asList(egze));
        new Expectations(){
            {
                egz1.czyTerminKolidujeZRezerwacjami((Date) any); returns(false, true, true);
                egz2.czyTerminKolidujeZRezerwacjami((Date) any); returns(false, true);
                egz3.czyTerminKolidujeZRezerwacjami((Date) any); returns(false);
            }
        };
        for (int i = 0; i < 3; i++) {
            EgzemplarzGry e = gra.znajdzWolnyEgzemplarz(termin);
            for (int j = 0; j < 3; j++) {
                if(i==j){
                    assertEquals(e, egze[j]);
                }else{
                    assertNotEquals(e, egze[j]);
                }
            }
        }
        
        new Verifications(){
            {
                egz1.equals(any); times = 3;
                egz2.equals(any); times = 3;
                egz3.equals(any); times = 3;
                
                egz1.czyTerminKolidujeZRezerwacjami(termin); times = 3;
                egz2.czyTerminKolidujeZRezerwacjami(termin); times = 2;
                egz3.czyTerminKolidujeZRezerwacjami(termin); times = 1;
            }
        };
    }
    
    @Test
    public void testDodajEgzemplarz(){
        System.out.println("dodajEgzemplarz");
        Gra gra = new Gra("Red Dead Redemption 2", "Rockstar", 2018, "PS4");
        EgzemplarzGry egze[] = {egz1, egz2, egz3};
        new Expectations(){
            {
                egze[0].getID(); returns(0);
                egze[1].getID(); returns(1);
                egze[2].getID(); returns(2);
                
                egze[0].equals(any); result = new Delegate(){
                    public boolean delegate(Object o){
                        return ((EgzemplarzGry)o).getID()==0;
                    }
                };
                egze[1].equals(any); result = new Delegate(){
                    public boolean delegate(Object o){
                        return ((EgzemplarzGry)o).getID()==1;
                    }
                };
                egze[2].equals(any); result = new Delegate(){
                    public boolean delegate(Object o){
                        return ((EgzemplarzGry)o).getID()==2;
                    }
                };
                
            }
        };
        
        for (int i = 0; i < 3; i++) {
            gra.dodajEgzemplarz(egze[i].getID());
            assertTrue(gra.getEgzemplarze().contains(egze[i]));
        }
        assertEquals(gra.getEgzemplarze().size(),3);
        
        new Verifications(){
            {
                egze[0].equals(any); times = 1;
                egze[1].equals(any); times = 2;
                egze[2].equals(any); times = 3;
                
            }
        };
    }
}