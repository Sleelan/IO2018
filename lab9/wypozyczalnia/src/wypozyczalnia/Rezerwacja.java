package wypozyczalnia;
import java.util.Date;

public class Rezerwacja {
    private EgzemplarzGry wypozyczonyEgzemplarz;
    private Klient wypozyczajacyKlient;
    private Date dataWygasniecia;
    private boolean wypozyczona;
    
    Rezerwacja(EgzemplarzGry newEgzemplarzGry, Klient newKlient, Date newTerminWygasniecia){
        
    }
    
    Rezerwacja(EgzemplarzGry newEgzemplarzGry, Klient newKlient, Date newTerminWygasniecia, boolean newWypozyczona){
        
    }
    public void przedluz(Date terminPrzedluzony){
        
    }
            
    @Override
    public String toString(){
        return null;
    }
}
