package jalotammi.tammipeli;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Pelinappula;
import static jalotammi.tammipeli.domain.Vari.PUNAINEN;
import static jalotammi.tammipeli.domain.Vari.VALKOINEN;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PelinappulaTest {
    Pelinappula p1; 
    Pelinappula p2;
    Pelilauta pelilauta;
    
    public PelinappulaTest() {
    }
    
    
    @Before
    public void setUp() {
        p1 = new Pelinappula(PUNAINEN, new Lukupari (7,6));
        p2 = new Pelinappula(VALKOINEN, new Lukupari (0,1));
        pelilauta = new Pelilauta();
    }
    @Test
    public void PelinappulaTavallinenPelinalkaessa(){
        assertEquals(false, p1.isKuningas());
    }
    @Test
    public void PunaisetLiikkuvatVainYlaViistoon(){
        assertEquals(true, p1.liikkuuko(pelilauta.getPelialusta()[6][5]));
        assertEquals(false, p1.liikkuuko(pelilauta.getPelialusta()[7][6]));
        assertEquals(false, p1.liikkuuko(pelilauta.getPelialusta()[5][5]));
        assertEquals(false, p1.liikkuuko(pelilauta.getPelialusta()[7][7]));
    }
    @Test
    public void ValkoisetLiikkuvatVainAlaViistoon(){
        assertEquals(true, p2.liikkuuko(pelilauta.getPelialusta()[1][2]));
        assertEquals(false, p2.liikkuuko(pelilauta.getPelialusta()[5][6]));
        assertEquals(false, p2.liikkuuko(pelilauta.getPelialusta()[0][1]));
        assertEquals(true, p2.liikkuuko(pelilauta.getPelialusta()[1][0]));
    }
    @Test
    public void KuninkaatLiikkuvatYlaJaAlaViistoon(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (4,5));
        p3.teeKuningas();
        assertEquals(true, p3.liikkuuko(pelilauta.getPelialusta()[3][6]));
        assertEquals(false, p3.liikkuuko(pelilauta.getPelialusta()[4][4]));
        assertEquals(false, p3.liikkuuko(pelilauta.getPelialusta()[5][5]));
        assertEquals(true, p3.liikkuuko(pelilauta.getPelialusta()[5][4]));
        assertEquals(true, p3.liikkuuko(pelilauta.getPelialusta()[3][4]));
        assertEquals(true, p3.liikkuuko(pelilauta.getPelialusta()[5][6]));
    }
    @Test
    public void NappulanPaalleEiVoiLiikkua(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (6,5));
        pelilauta.getPelialusta()[6][5].setNappula(p3);
        assertEquals(false, p1.liikkuuko(pelilauta.getPelialusta()[6][5]));
    }
    @Test
    public void ValkoisetSyovatAlaViistoon(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (1,2));
        pelilauta.getPelialusta()[1][2].setNappula(p3);
        assertEquals(true, p2.syoko(pelilauta.getPelialusta()[1][2],pelilauta.getPelialusta()[2][3]));
        assertEquals(false, p2.syoko(pelilauta.getPelialusta()[1][2],pelilauta.getPelialusta()[0][3]));
    }
    @Test
    public void PunaisetSyovatYlaViistoon(){
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (6,5));
        pelilauta.getPelialusta()[6][5].setNappula(p3);
        assertEquals(true, p1.syoko(pelilauta.getPelialusta()[6][5],pelilauta.getPelialusta()[5][4]));
        assertEquals(false, p1.syoko(pelilauta.getPelialusta()[6][6],pelilauta.getPelialusta()[5][4]));
    }
    @Test
     public void KuninkaatSyovatYlaJaAlaViistoon(){
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (4,5));
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (3,4));
        Pelinappula p5 = new Pelinappula (PUNAINEN, new Lukupari (5,6));
        p3.teeKuningas();
        pelilauta.getPelialusta()[4][5].setNappula(p3);
        pelilauta.getPelialusta()[3][4].setNappula(p4);
        pelilauta.getPelialusta()[5][6].setNappula(p5);
         assertEquals(true, p3.syoko(pelilauta.getPelialusta()[3][4],pelilauta.getPelialusta()[2][3]));
        assertEquals(true, p3.syoko(pelilauta.getPelialusta()[5][6],pelilauta.getPelialusta()[6][7]));
    }
     @Test
     public void nappulaEiSyoJosEdessaNappula(){
         Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (1,2));
        pelilauta.getPelialusta()[1][2].setNappula(p3);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (2,3));
        pelilauta.getPelialusta()[2][3].setNappula(p3);
        assertEquals(false, p2.syoko(pelilauta.getPelialusta()[1][2],pelilauta.getPelialusta()[2][3]));
     }
    
    @After
    public void tearDown() {
    }
}
