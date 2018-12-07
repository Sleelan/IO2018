package wypozyczalnia;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Gra {
    private String tytul;
    private String wydawnictwo;
    private int rokWydania = -1;
    private String platforma;
    private List<EgzemplarzGry> egzemplarze;
    
    Gra(String newTytul, String newWydawnictwo, int newRokWydania, String newPlatforma){
        tytul = newTytul;
        wydawnictwo = newWydawnictwo;
        rokWydania = newRokWydania;
        platforma = newPlatforma;
        
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
    
    @Override
    public boolean equals(Object o){
        Gra gra = (Gra)o;
        if(gra.tytul != null && this.tytul != gra.tytul)
            return false;
        if(gra.platforma != null && this.platforma != gra.platforma)
            return false;
        if(gra.rokWydania != -1 && this.rokWydania != gra.rokWydania)
            return false;
        if(gra.wydawnictwo != null && this.wydawnictwo != gra.wydawnictwo)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.tytul);
        hash = 17 * hash + Objects.hashCode(this.wydawnictwo);
        hash = 17 * hash + this.rokWydania;
        hash = 17 * hash + Objects.hashCode(this.platforma);
        return hash;
    }
}
