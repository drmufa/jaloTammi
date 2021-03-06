/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelilauta;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jajnousi
 */
public class PelaajaTest {
    Pelilauta pl;
    Pelaaja sepi;
    Pelaaja topi;
   
    public PelaajaTest() {
    }
     
    @Before
    public void setUp() {
       this.pl = new Pelilauta();
       this.sepi = new Pelaaja("Seppo", pl);
       this.topi = new Pelaaja("Topias", pl);
       pl.lisaaPeliNappulat();
       sepi.setVari(Vari.PUNAINEN);
       topi.setVari(Vari.VALKOINEN);
    }
    
    @Test
    public void punainenliikkuuOikeallePaikalle(){
        sepi.siirraNappula(pl.getPelialusta()[5][2], pl.getPelialusta()[4][3]);
        assertEquals(pl.getPelialusta()[4][3].getNappula().getVari(), PUNAINEN);
        assertEquals(pl.getPelialusta()[5][2].getNappula(), null);
    }
    @Test
    public void valkoinenliikkuuOikeallePaikalle(){
        topi.siirraNappula(pl.getPelialusta()[2][3], pl.getPelialusta()[3][4]);
        assertEquals(pl.getPelialusta()[3][4].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[2][3].getNappula(), null);
    }
    @Test
    public void vaaraLiikeEiTeeMitaan(){
        topi.siirraNappula(pl.getPelialusta()[2][3], pl.getPelialusta()[3][3]);
        assertEquals(pl.getPelialusta()[3][3].getNappula(), null);
        assertEquals(pl.getPelialusta()[2][3].getNappula().getVari(), VALKOINEN);
    }
    @Test
    public void vaaraLiikePaalleEiTeeMitaan(){
        sepi.siirraNappula(pl.getPelialusta()[7][2], pl.getPelialusta()[6][3]);
        assertEquals(pl.getPelialusta()[7][2].getNappula().getVari(), PUNAINEN);
        assertEquals(pl.getPelialusta()[6][3].getNappula().getVari(), PUNAINEN);
    }
    @Test
    public void vaaraVariLiikeEiTeeMitaan(){
        topi.siirraNappula(pl.getPelialusta()[5][2], pl.getPelialusta()[4][3]);
        assertEquals(pl.getPelialusta()[4][3].getNappula(), null);
        assertEquals(pl.getPelialusta()[5][2].getNappula().getVari(), PUNAINEN);
    }
    
    @Test
    public void tyhjaLiikeEiTeeMitaan(){
        sepi.siirraNappula(pl.getPelialusta()[3][3], pl.getPelialusta()[2][3]);
        assertEquals(pl.getPelialusta()[2][3].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[3][3].getNappula(), null);
    }
    @Test
    public void valkoinensyoPunaisen(){
        topi.siirraNappula(pl.getPelialusta()[2][3], pl.getPelialusta()[3][4]);
        sepi.siirraNappula(pl.getPelialusta()[5][6], pl.getPelialusta()[4][5]);
        topi.syoNappulalla(pl.getPelialusta()[3][4],pl.getPelialusta()[4][5], pl.getPelialusta()[5][6]);
        assertEquals(pl.getPelialusta()[5][6].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[4][5].getNappula(), null);
        assertEquals(pl.getPelialusta()[3][4].getNappula(), null);
        assertEquals(topi.getSiirrot(), 2);
        assertEquals(sepi.getSiirrot(), 1);
    }
    @Test
    public void testaaLiikutaNappula(){
        topi.liikutaNappulaa(pl.getPelialusta()[2][3], pl.getPelialusta()[3][4],pl.getPelialusta()[3][4]);
        sepi.liikutaNappulaa(pl.getPelialusta()[5][6], pl.getPelialusta()[4][5], pl.getPelialusta()[4][5]);
        topi.liikutaNappulaa(pl.getPelialusta()[3][4],pl.getPelialusta()[4][5], pl.getPelialusta()[5][6]);
        assertEquals(pl.getPelialusta()[5][6].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[4][5].getNappula(), null);
        assertEquals(pl.getPelialusta()[3][4].getNappula(), null);
        assertEquals(topi.getSiirrot(), 2);
        assertEquals(sepi.getSiirrot(), 1);
    }
    @Test
    public void testaaLiikutaNappula2(){
        sepi.liikutaNappulaa(pl.getPelialusta()[7][2], pl.getPelialusta()[6][3], pl.getPelialusta()[6][3]);
        assertEquals(pl.getPelialusta()[7][2].getNappula().getVari(), PUNAINEN);
        assertEquals(pl.getPelialusta()[6][3].getNappula().getVari(), PUNAINEN);
    }
    @Test
    public void testaaAlustavuoronVuoronVaihtoa(){
        sepi.alustaVuoro();
        assertEquals(sepi.isVuorossa(), true);
    }
    @Test
    public void testaaAlustavuoronNappulalistaa(){
        sepi.alustaVuoro();
        assertEquals(sepi.getNappulat().size(), 12);
    }
     @Test
    public void testaaAlustavuoronSyovatlistaa(){
        sepi.alustaVuoro();
        assertEquals(sepi.getSyovat().size(), 0);
    }
     @Test
    public void testaaAlustavuoronSyovyt(){
        sepi.alustaVuoro();
        assertEquals(sepi.getSyonyt(), null);
    }
    @Test
    public void testaaAlustavuoronNappulatMäärä(){
        sepi.alustaVuoro();
        assertEquals(sepi.alustaVuoro(), true);
    }
}
