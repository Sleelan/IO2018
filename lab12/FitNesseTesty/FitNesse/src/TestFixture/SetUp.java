package TestFixture;

import fit.Fixture;
import wypozyczalnia.Fasada;
public class SetUp extends Fixture {
    static Fasada fasada;
    public SetUp() 
    {
        fasada = new Fasada();
    }
}
