package wypozyczalnia;
import java.util.ArrayList;
import java.util.List;
public class Klient {
    private int id;
    private List<Rezerwacja> rezerwacje;
    
    Klient(int newID){
        
    }
    
    public EgzemplarzGry wyszukajEgzemplarz(int idEgzemplarza){
        return null;
    }
    
    @Override
    public String toString(){
        return null;
    }
    
    public Boolean equals(Klient klient){
        if (this.id == klient.id){
            return true;
        }
        else{
            return false;
        }
    }
}
