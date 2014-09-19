/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli;

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelilauta;
import static jalotammi.tammipeli.Vari.MUSTA;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PelilautaTest {
    
    public PelilautaTest() {
    }
    
    @Before
    public void setUp() {
    }
    @Test
    public void jokaToinenRuutuMusta(){
        Pelilauta pl = new Pelilauta();
        assertEquals(pl.getPelialusta()[0][1].getVari(), MUSTA);
        assertEquals(pl.getPelialusta()[1][2].getVari(), MUSTA);
        assertEquals(pl.getPelialusta()[7][4].getVari(), MUSTA);
    }
    @Test
    public void jokaToinenRuutuValkoinen(){
        Pelilauta pl = new Pelilauta();
        assertEquals(pl.getPelialusta()[0][0].getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[3][3].getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[7][5].getVari(), VALKOINEN);
    }
    @Test
    public void ValkoisetNappulatPaikoillaan(){
        Pelilauta pl = new Pelilauta();
        pl.lisaaPeliNappulat();
        assertEquals(pl.getPelialusta()[0][0].getNappula(), null);
        assertEquals(pl.getPelialusta()[0][2].getNappula(), null);
        assertEquals(pl.getPelialusta()[1][1].getNappula(), null);
        assertEquals(pl.getPelialusta()[5][2].getNappula().getVari(), PUNAINEN);
        assertEquals(pl.getPelialusta()[6][1].getNappula().getVari(), PUNAINEN);
        assertEquals(pl.getPelialusta()[7][6].getNappula().getVari(), PUNAINEN);
    }
    @Test
    public void PunaisetNappulatPaikoillaan(){
        Pelilauta pl = new Pelilauta();
        pl.lisaaPeliNappulat();
        assertEquals(pl.getPelialusta()[0][2].getNappula(), null);
        assertEquals(pl.getPelialusta()[4][3].getNappula(), null);
        assertEquals(pl.getPelialusta()[3][4].getNappula(), null);
        assertEquals(pl.getPelialusta()[2][3].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[0][3].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[1][0].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[1][4].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[2][1].getNappula().getVari(), VALKOINEN);
        assertEquals(pl.getPelialusta()[2][5].getNappula().getVari(), VALKOINEN);
    }
   
}
