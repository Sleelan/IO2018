package wypozyczalnia;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Gra {
    private String tytul;
    private String wydawnictwo;
    private int rokWydania = -1;
    private String platforma;
    private List<EgzemplarzGry> egzemplarze = new ArrayList<EgzemplarzGry>();
    
    Gra(String newTytul, String newWydawnictwo, int newRokWydania, String newPlatforma){
        tytul = newTytul;
        wydawnictwo = newWydawnictwo;
        rokWydania = newRokWydania;
        platforma = newPlatforma;
    }
    
    public List<EgzemplarzGry> getEgzemplarze(){
        return egzemplarze;
    }
    
    public void setEgzemplarze(List<EgzemplarzGry> l){
        this.egzemplarze = l;
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
    
    public EgzemplarzGry wyszukajEgzemplarz(int idEgzemplarza){
        EgzemplarzGry egzemplarz = new EgzemplarzGry(idEgzemplarza, this);
        int index = egzemplarze.indexOf(egzemplarz);
        if(index != -1){
            return egzemplarze.get(index);
        }
        return null;
    }
    
    public void dodajEgzemplarz(int idEgzemplarza){
        EgzemplarzGry egzemplarz = new EgzemplarzGry(idEgzemplarza, this);
        if(wyszukajEgzemplarz(idEgzemplarza)==null)
            egzemplarze.add(egzemplarz);
    }
    
    public String getTytul(){
        return this.tytul;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tytul: ");
        sb.append(tytul);
        sb.append(", Wydawnictwo: ");
        sb.append(wydawnictwo);
        sb.append(", Rok Wydania: ");
        sb.append(rokWydania);
        sb.append(", Platforma: ");
        sb.append(platforma);
        sb.append("\n Egzemplarze:\n");
        for(EgzemplarzGry e : egzemplarze){
            sb.append("\t");
            sb.append(e.toString());
            sb.append("\n");
        }
        return sb.toString();
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
}
