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
    public Gra wyszukajGre(String[] daneGry){
        Gra gra = fabryka.stworzGre(daneGry);
        int index = gry.indexOf(gra);
        if(index != -1){
            return gry.get(index);
        }
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
        if(wyszukajGre(daneGry)==null)
            gry.add(gra);
    }
    
    public void dodajEgzemplarz(String[] daneGry, int idEgzemplarza){
        Gra gra = wyszukajGre(daneGry);
        if(gra != null)
            gra.dodajEgzemplarz(idEgzemplarza);
    }
    
    public void dodajKlienta(int id){
        Klient klient = new Klient(id);
        if(wyszukajKlienta(id)==null)
            klienci.add(klient);
    }
    
    public void usunEgzemplarz(int idEgzemplarza){
        
    }
    
    public void przedluzWypozyczenie(int idKlienta, int idEgzemplarza, String[] daneGry, Date terminPrzedluzony){
        Klient klient = wyszukajKlienta(idKlienta);
        if (klient != null) {
            Gra gra = wyszukajGre(daneGry);
            if(gra != null){
                EgzemplarzGry egzemplarz = gra.wyszukajEgzemplarz(idEgzemplarza);
                if(egzemplarz != null){
                    klient.przedluzWypozyczenie(egzemplarz, terminPrzedluzony);
                }
            }
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
    
    @Override
    public String toString(){
        String result = "Klienci:\n";
        for(Klient k : klienci){
            result += "\t" + k.toString() + "\n";
        }
        result += "Gry:\n";
        for(Gra g : gry){
            result += "\t" + g.toString() + "\n";
        }
        return result;
    }
    
    public static void main(String[] args){
        Fasada fasada = new Fasada();
        fasada.dodajKlienta(0);
        fasada.dodajKlienta(1);
        fasada.dodajKlienta(2);
        fasada.dodajKlienta(1);
        String[] daneGry1 = {"Red Dead Redemption 2", "Rockstar", "2018", "PS4"};
        String[] daneGry2 = {"Dark Souls", "From Software", "2014", "PC"};
        fasada.dodajGre(daneGry1);
        fasada.dodajGre(daneGry2);
        fasada.dodajGre(daneGry1);
        
        fasada.dodajEgzemplarz(daneGry1, 0);
        fasada.dodajEgzemplarz(daneGry1, 1);
        fasada.dodajEgzemplarz(daneGry1, 1);
        fasada.dodajEgzemplarz(daneGry2, 2);
        fasada.dodajEgzemplarz(daneGry2, 3);
        fasada.dodajEgzemplarz(daneGry2, 4);
        
        Date data1 = new Date(); //aktualna data
        Date data2 = new Date(data1.getTime()+216000000); // aktualna data + 60h
        Date data3 = new Date(data2.getTime()+86400000); // data2 + 24h
        fasada.zarezerwujGre(0, daneGry1, data3);
        fasada.zarezerwujGre(1, daneGry2, data2);
        
        System.out.println("Stan początkowy:\n");
        System.out.println(fasada.toString());
        System.out.println("Przedłużanie rezerwacji...\n");
        
        fasada.przedluzWypozyczenie(1, 2, daneGry2, data3);
        System.out.println(fasada.toString());
        //System.out.println(data1);
        //System.out.println(data2);
        //System.out.println(data3);
        
    }
}
