package wypozyczalnia;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class EgzemplarzGry {
    private int id;
    private Gra gra;
    private List<Rezerwacja> rezerwacja = new ArrayList<Rezerwacja>();
    
    EgzemplarzGry(int newID, Gra newGra){
        
    }
    
    EgzemplarzGry(int newID, Gra newGra, Rezerwacja newRezerwacja){
        
    }
    
    public Boolean czyTerminKolidujeZRezerwacjami(Date terminPrzedluzony){
        return false;
    }
    
    public Rezerwacja wyszukajRezerwacje(int idKlienta){
        return null;
    }
    
    @Override
    public String toString(){
        return null;
    }
}
