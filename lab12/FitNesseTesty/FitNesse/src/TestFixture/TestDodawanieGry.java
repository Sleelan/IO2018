package TestFixture;

import java.util.IllegalFormatCodePointException;
import fit.ColumnFixture;
public class TestDodawanieGry extends ColumnFixture {
    String dane[];
    
    public boolean dodajGre() throws IllegalFormatCodePointException
    {
        int s1 = liczbaGier();
        try
        {
            SetUp.fasada.dodajGre(dane);
            int s2 = liczbaGier();
            return s1!=s2;
        } catch(IllegalFormatCodePointException e) {}
        return false;
    }
    public int liczbaGier()
    {
        return SetUp.fasada.getGry().size();
    }
}
