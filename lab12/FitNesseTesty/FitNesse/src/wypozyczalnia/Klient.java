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
    
    public void przedluzWypozyczenie(EgzemplarzGry egzemplarz, Date terminPrzedluzony){
        Rezerwacja rezerwacja = wyszukajRezerwacjeNaEgzemplarz(egzemplarz);
        if (rezerwacja != null){
            rezerwacja.przedluz(terminPrzedluzony);
        }
    }
    
    public void przypiszRezerwacje(Rezerwacja rezerwacja){
        rezerwacje.add(rezerwacja);
    }
    
    public Rezerwacja wyszukajRezerwacjeNaEgzemplarz(EgzemplarzGry egzemplarz){
        for(Rezerwacja r : rezerwacje){
            if(r.getEgzemplarz() == egzemplarz){
                return r;
            }
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
}
