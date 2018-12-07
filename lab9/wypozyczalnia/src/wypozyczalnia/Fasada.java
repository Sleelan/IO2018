package wypozyczalnia;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Fasada {
    private List<Gra> gry = new ArrayList<Gra>();
    private List<Klient> klienci = new ArrayList<Klient>();
    private Fabryka fabryka = new Fabryka();
    
    public Klient wyszukajKlienta(int id){
        Klient klient = new Klient(id);
        int index = klienci.indexOf(klient);
        if (index != -1){
            return klienci.get(index);
        }
        return null;
    }
    public Gra wyszukajGre(String[] daneGy){
        return null;
    }
    public Gra sprawdzDostepnoscGry(int id){
        return null;
    }
    
    public Rezerwacja sprawdzRezerwacjeGry(int idKlienta, int idEgzemplarza){
        return null;
    }
    
    public void dodajGre(String[] daneGry){
        Gra gra = fabryka.stworzGre(daneGry);
        gry.add(gra);
    }
    
    public void usunEgzemplarz(int idEgzemplarza){
        
    }
    
    public void przedluzWypozyczenie(int idKlienta, int idEgzemplarza, Date terminPrzedluzony){
        Klient klient = wyszukajKlienta(idKlienta);
        if (klient != null) {
            klient.przedluzWypozyczenie(idEgzemplarza, terminPrzedluzony);
        }
            
    }
    
    public void zarezerwujGre(int idKlienta, String[] daneGry, Date terminEkspiracji){
        Klient klient = wyszukajKlienta(idKlienta);
        if (klient != null) {
            Gra gra = wyszukajGre(daneGry);
            if (gra != null){
                EgzemplarzGry egzemplarz = gra.znajdzWolnyEgzemplarz(terminEkspiracji);
                if (egzemplarz != null){
                    Rezerwacja rezerwacja = fabryka.stworzRezerwacje(egzemplarz, klient, terminEkspiracji);
                    klient.przypiszRezerwacje(rezerwacja);
                    egzemplarz.przypiszRezerwacje(rezerwacja);
                }
            }
        }
    }
    
    public void wypozyczZarezerwowanaGre(int idKlienta, int idEgzemplarza, Date terminOddania){
        
    }
    
    public static void main(String[] args){
        
    }
}
