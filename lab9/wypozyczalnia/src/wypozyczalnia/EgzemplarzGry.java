package wypozyczalnia;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EgzemplarzGry {
    private int id;
    private Gra gra;
    private List<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
    
    EgzemplarzGry(int newID, Gra newGra){
        
    }
    
    EgzemplarzGry(int newID, Gra newGra, Rezerwacja newRezerwacja){
        
    }
    
    public Boolean czyTerminKolidujeZRezerwacjami(Date terminPrzedluzony){
        Iterator<Rezerwacja> it = rezerwacje.iterator();
        while (it.hasNext()){
            Rezerwacja rezerwacja = it.next();
            if (rezerwacja.czyKolidujeZTerminem(terminPrzedluzony) == true){
                return true;
            }
        }
        return false;
    }
    
    public Rezerwacja wyszukajRezerwacje(int idKlienta){
        return null;
    }
    
    public void przypiszRezerwacje(Rezerwacja rezerwacja){
        rezerwacje.add(rezerwacja);
    }
    
    @Override
    public String toString(){
        return null;
    }
}
