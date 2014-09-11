/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli;

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Vari;
import static jalotammi.tammipeli.domain.Vari.MUSTA;
import static jalotammi.tammipeli.domain.Vari.VALKOINEN;
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
    


}
