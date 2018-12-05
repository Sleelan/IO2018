package wypozyczalnia;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Gra {
    private String tytul;
    private String wydawnictwo;
    private int rokWydania;
    private String platforma;
    private List<EgzemplarzGry> egzemplarze;
    
    Gra(String newTytul, String newWydawnictwo, int newRokWydania, String newPlatforma){
        
    }
    
    public EgzemplarzGry znajdzWolnyEgzemplarz (Date terminEkspiracji){
        Iterator<EgzemplarzGry> it = egzemplarze.iterator();
        while (it.hasNext()){
            EgzemplarzGry egzemplarz = it.next();
            if (egzemplarz.czyTerminKolidujeZRezerwacjami(terminEkspiracji) == false){
                return egzemplarz;
            }
        }
        return null;
    }
    
    @Override
    public String toString(){
        return null;
    }
}
