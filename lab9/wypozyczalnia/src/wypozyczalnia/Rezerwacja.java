package wypozyczalnia;
import java.util.Date;

public class Rezerwacja {
    private EgzemplarzGry wypozyczonyEgzemplarz;
    private Klient wypozyczajacyKlient;
    private Date dataWygasniecia;
    private Date terminStartu;
    private boolean wypozyczona;
    
    Rezerwacja(EgzemplarzGry newEgzemplarzGry, Klient newKlient, Date newTerminWygasniecia){
        wypozyczonyEgzemplarz = newEgzemplarzGry;
        wypozyczajacyKlient = newKlient;
        dataWygasniecia = newTerminWygasniecia;
        terminStartu = new Date();
        wypozyczona = false;
    }
    
    Rezerwacja(EgzemplarzGry newEgzemplarzGry, Klient newKlient, Date newTerminWygasniecia, boolean newWypozyczona){
        wypozyczonyEgzemplarz = newEgzemplarzGry;
        wypozyczajacyKlient = newKlient;
        dataWygasniecia = newTerminWygasniecia;
        terminStartu = new Date();
        wypozyczona = newWypozyczona;
        
    }
    
    public void przedluz(Date terminPrzedluzony){
        if (wypozyczonyEgzemplarz.czyTerminKolidujeZRezerwacjami(terminPrzedluzony) == false){
            dataWygasniecia = terminPrzedluzony;
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
        String result = "Zarezerwowane przez klienta o " + wypozyczajacyKlient + ", od " + terminStartu + " do " + dataWygasniecia;
        return result;
    }
}
