package wypozyczalnia;



import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class EgzemplarzGry {
    private int id;
    private Gra gra;
    private List<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
    
    EgzemplarzGry(int newID, Gra newGra){
        this.id = newID;
        this.gra = newGra;
    }
    
    public int getID(){
        return id;
    }
    
    public boolean czyTerminKolidujeZRezerwacjami(Date terminPrzedluzony){
        for(Rezerwacja r : rezerwacje){
            if(r.czyKolidujeZTerminem(terminPrzedluzony)==true){
                return true;
            }
        }
        return false;
    }
    
    public Rezerwacja wyszukajRezerwacje(int idKlienta){
        return null;
    }
    
    public void przypiszRezerwacje(Rezerwacja rezerwacja){
        rezerwacje.add(rezerwacja);
    }
    
    @Override
    public String toString(){
        String result = "Gra: " + gra.getTytul() + ", ID: " + id;
        result += "\tRezerwacje:";
        for(Rezerwacja r : rezerwacje){
            result += "\n\t" + r.toString();
        }
        return result;
    }
    
    @Override
    public boolean equals(Object o){
        EgzemplarzGry e = (EgzemplarzGry)o;
        if(this.gra != e.gra)
            return false;
        if(this.id != e.id)
            return false;
        return true;
    }
}
