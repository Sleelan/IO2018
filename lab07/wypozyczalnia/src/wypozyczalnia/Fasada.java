package wypozyczalnia;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Fasada {
    private List<Gra> gry = new ArrayList<Gra>();
    private List<Klient> klienci = new ArrayList<Klient>();
    
    public Klient sprawdzKlienta(int id){
        return null;
    }
    
    public Gra sprawdzDostepnoscGry(int id){
        return null;
    }
    
    public Rezerwacja sprawdzRezerwacjeGry(int idKlienta, int idEgzemplarza){
        return null;
    }
    
    public Gra szukajGry(String tytul){
        return null;
    }
    
    public Gra szukajGry(String tytul, String wydawnictwo){
        return null;
    }
    
    public Gra szukajGry(String tytul, String wydawnictwo, int rokWydania){
        return null;
    }
    
    public Gra szukajGry(String tytul, String wydawnictwo, int rokWydania, String platforma){
        return null;
    }
    
    public void dodajGre(String newTytul, String newWydawnictwo, int newRokWydania, String newPlatforma){
        
    }
    
    public void usunEgzemplarz(int idEgzemplarza){
        
    }
    
    public void przedluzWypozyczenie(int idKlienta, int idEgzemplarza, Date terminPrzedlozony){
        
    }
    
    public void wypozyczZarezerwowanaGre(int idKlienta, int idEgzemplarza, Date terminOddania){
        
    }
    
    public static void main(String[] args){
        
    }
}
