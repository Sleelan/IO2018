package wypozyczalnia;
import java.util.Date;

public class Fabryka {
    
    Fabryka (){
        
    }
    
    public Rezerwacja stworzRezerwacje(EgzemplarzGry egzemplarz, Klient klient, Date terminWygasniecia){
        Rezerwacja rezerwacja = new Rezerwacja(egzemplarz, klient, terminWygasniecia );
        return rezerwacja;
    }
    
    public Gra stworzGre(String[] daneGry){
        if (daneGry.length == 4){    
            String newTytul = daneGry[0];
            String newWydawnictwo = daneGry[1];
            int newRokWydania = Integer.parseInt(daneGry[2]);
            String newPlatforma = daneGry [3];
            Gra nowaGra = new Gra(newTytul, newWydawnictwo, newRokWydania, newPlatforma);
            return nowaGra;
        }
        return null;
    }
}
