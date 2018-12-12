package wypozyczalnia;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Klient {
    private int id;
    private List<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
    
    Klient(int newID){
        this.id = newID;
    }
    
    public EgzemplarzGry wyszukajEgzemplarz(int idEgzemplarza){
        return null;
    }
    
    public void przedluzWypozyczenie(int idEgzemplarza, Date terminPrzedluzony){
        Rezerwacja rezerwacja = wyszukajRezerwacjeNaEgzemplarz(idEgzemplarza);
        if (rezerwacja != null){
            rezerwacja.przedluz(terminPrzedluzony);
        }
    }
    
    public void przypiszRezerwacje(Rezerwacja rezerwacja){
        rezerwacje.add(rezerwacja);
    }
    
    public Rezerwacja wyszukajRezerwacjeNaEgzemplarz(int idEgzemplarza){
        Rezerwacja rezerwacja = rezerwacje.get(idEgzemplarza);
        if (rezerwacje.indexOf(rezerwacja) != -1 ){
            return rezerwacja;
        }
        return null;
    }
    
    @Override
    public String toString(){
        return "ID: " + id;
    }
    
    @Override
    public boolean equals(Object o){
        Klient klient = (Klient)o;
        if (this.id == klient.id){
            return true;
        }
        else{
            return false;
        }
    }
    /*
    public boolean equals(Klient klient){
        if (this.id == klient.id){
            return true;
        }
        else{
            return false;
        }
    }*/
}
