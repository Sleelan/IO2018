package wypozyczalnia;
import java.util.Date;
import static java.util.Date.parse;

public class Rezerwacja {
    private EgzemplarzGry wypozyczonyEgzemplarz;
    private Klient wypozyczajacyKlient;
    private Date dataWygasniecia;
    private Date terminStartu;
    private boolean wypozyczona;
    
    Rezerwacja(EgzemplarzGry newEgzemplarzGry, Klient newKlient, Date newTerminWygasniecia){
        
    }
    
    Rezerwacja(EgzemplarzGry newEgzemplarzGry, Klient newKlient, Date newTerminWygasniecia, boolean newWypozyczona){
        
    }
    
    public void przedluz(Date terminPrzedluzony){
        if (wypozyczonyEgzemplarz.czyTerminKolidujeZRezerwacjami(terminPrzedluzony) == false){
            dataWygasniecia.setTime(parse(terminPrzedluzony.toString()));
        }
    }
    
    public boolean czyKolidujeZTerminem(Date termin){
        if (terminStartu.after(termin) == true){
            return false;
        }
        return true;
    }
            
    @Override
    public String toString(){
        return null;
    }
}
