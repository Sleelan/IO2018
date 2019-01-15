/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wypozyczalnia;

import java.util.Date;

public class Dane {
    public String dane_gier[][] = {
        {"Red Dead Redemption 2", "Rockstar", "2018", "PS4"},
        {"Dark Souls", "From Software", "2014", "PC"},
        {"TES V - Skyrim", "Bethesda", "2012", "PC"},
        {"TES V - Skyrim", "Bethesda", "2012", "PS3"},
        {"Wiedźmin 3: Dziki Gon", "CDProjekt Red", "2015", "PC"},
        {"Dying Light", "Techland", "2015", "PC"}
    };
    
    public Gra gry[] = {
        new Gra(dane_gier[0][0], dane_gier[0][1], Integer.parseInt(dane_gier[0][2]), dane_gier[0][3]),
        new Gra(dane_gier[1][0], dane_gier[1][1], Integer.parseInt(dane_gier[1][2]), dane_gier[1][3]),
        new Gra(dane_gier[2][0], dane_gier[2][1], Integer.parseInt(dane_gier[2][2]), dane_gier[2][3]),
        new Gra(dane_gier[3][0], dane_gier[3][1], Integer.parseInt(dane_gier[3][2]), dane_gier[3][3]),
        new Gra(dane_gier[4][0], dane_gier[4][1], Integer.parseInt(dane_gier[4][2]), dane_gier[4][3]),
        new Gra(dane_gier[5][0], dane_gier[5][1], Integer.parseInt(dane_gier[5][2]), dane_gier[5][3])
    };
    
    private Date aktualna_data = new Date();
    private long dzien = 86400000;
    public Date daty[] = {
        new Date(aktualna_data.getTime()+0*dzien),
        new Date(aktualna_data.getTime()+1*dzien),
        new Date(aktualna_data.getTime()+2*dzien),
        new Date(aktualna_data.getTime()+3*dzien),
        new Date(aktualna_data.getTime()+4*dzien),
        new Date(aktualna_data.getTime()+5*dzien),
        new Date(aktualna_data.getTime()+6*dzien),
        new Date(aktualna_data.getTime()+7*dzien),
        new Date(aktualna_data.getTime()+8*dzien)
    };
    
    public Klient klienci[] = {
        new Klient(0),
        new Klient(1),
        new Klient(2),
        new Klient(3),
        new Klient(4),
        new Klient(5),
        new Klient(6),
        new Klient(7),
        new Klient(8)
    };

    public EgzemplarzGry egzemplarze[] = {
        new EgzemplarzGry(0, gry[0]),
        new EgzemplarzGry(1, gry[1]),
        new EgzemplarzGry(2, gry[2]),
        new EgzemplarzGry(3, gry[3]),
        new EgzemplarzGry(4, gry[4]),
        new EgzemplarzGry(5, gry[5]),
        new EgzemplarzGry(6, gry[3]),
        new EgzemplarzGry(7, gry[1]),
        new EgzemplarzGry(8, gry[0])
    };
    
    public Rezerwacja rezerwacje[] = {
        new Rezerwacja(egzemplarze[0], klienci[0], daty[0]),
        new Rezerwacja(egzemplarze[1], klienci[1], daty[1]),
        new Rezerwacja(egzemplarze[2], klienci[2], daty[2]),
        new Rezerwacja(egzemplarze[3], klienci[3], daty[3]),
        new Rezerwacja(egzemplarze[4], klienci[4], daty[4]),
        new Rezerwacja(egzemplarze[5], klienci[5], daty[5]),
        new Rezerwacja(egzemplarze[6], klienci[6], daty[6]),
        new Rezerwacja(egzemplarze[7], klienci[7], daty[7]),
        new Rezerwacja(egzemplarze[8], klienci[8], daty[8])
    };
}
