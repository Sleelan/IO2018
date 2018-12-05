package wypozyczalnia;
import java.util.Date;

public class Fabryka {
    
    Fabryka (){
        
    }
    
    public Rezerwacja stworzRezerwacje(EgzemplarzGry egzemplarz, Klient klient, Date terminWygasniecia){
        Rezerwacja rezerwacja = new Rezerwacja(egzemplarz, klient, terminWygasniecia );
        return rezerwacja;
    }
}
