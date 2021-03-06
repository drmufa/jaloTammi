package jalotammi.tammipeli.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Pelinappula;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
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
        pelilauta = new Pelilauta();
        p1 = new Pelinappula(PUNAINEN, new Lukupari (7,6), pelilauta);
        p2 = new Pelinappula(VALKOINEN, new Lukupari (0,1), pelilauta);
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
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (4,5), pelilauta);
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
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (6,5), pelilauta);
        pelilauta.getPelialusta()[6][5].setNappula(p3);
        assertEquals(false, p1.liikkuuko(pelilauta.getPelialusta()[6][5]));
    }
    @Test
    public void ValkoisetSyovatAlaViistoon(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (1,2), pelilauta);
        pelilauta.getPelialusta()[1][2].setNappula(p3);
        assertEquals(true, p2.syoko(pelilauta.getPelialusta()[1][2],pelilauta.getPelialusta()[2][3]));
        assertEquals(false, p2.syoko(pelilauta.getPelialusta()[1][2],pelilauta.getPelialusta()[0][3]));
    }
    @Test
    public void PunaisetSyovatYlaViistoon(){
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (6,5), pelilauta);
        pelilauta.getPelialusta()[6][5].setNappula(p3);
        assertEquals(true, p1.syoko(pelilauta.getPelialusta()[6][5],pelilauta.getPelialusta()[5][4]));
        assertEquals(false, p1.syoko(pelilauta.getPelialusta()[6][6],pelilauta.getPelialusta()[5][4]));
    }
    @Test
     public void KuninkaatSyovatYlaJaAlaViistoon(){
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (4,5), pelilauta);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (3,4), pelilauta);
        Pelinappula p5 = new Pelinappula (PUNAINEN, new Lukupari (5,6), pelilauta);
        p3.teeKuningas();
        pelilauta.getPelialusta()[4][5].setNappula(p3);
        pelilauta.getPelialusta()[3][4].setNappula(p4);
        pelilauta.getPelialusta()[5][6].setNappula(p5);
        assertEquals(true, p3.syoko(pelilauta.getPelialusta()[3][4],pelilauta.getPelialusta()[2][3]));
        assertEquals(true, p3.syoko(pelilauta.getPelialusta()[5][6],pelilauta.getPelialusta()[6][7]));
    }
     @Test
     public void nappulaEiSyoJosEdessaNappula(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (1,2), pelilauta);
        pelilauta.getPelialusta()[1][2].setNappula(p3);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (2,3), pelilauta);
        pelilauta.getPelialusta()[2][3].setNappula(p3);
        assertEquals(false, p2.syoko(pelilauta.getPelialusta()[1][2],pelilauta.getPelialusta()[2][3]));
     }
     @Test
    public void PunaisetPystyySyoMaanYlaViistoon(){
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (6,5), pelilauta);
        pelilauta.getPelialusta()[6][5].setNappula(p3);
        assertEquals(true, p1.pystyykoSyomaan());
    }
    @Test
    public void PunaisetEiPystySyomaanYlaViistoonKunEisyotavaa(){
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (6,5), pelilauta);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (3,4), pelilauta);
        pelilauta.getRuutu(5, 4).setNappula(p4);
        pelilauta.getPelialusta()[6][5].setNappula(p3);
        assertEquals(false, p1.pystyykoSyomaan());
    }
    @Test
    public void ValkoisetPystyySyoMaanAlaViistoon(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (1,2), pelilauta);
        pelilauta.getPelialusta()[1][2].setNappula(p3);
        assertEquals(true, p2.pystyykoSyomaan());
    }
    @Test
    public void ValkoisetEiPystySyoMaanYlaViistoon(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (1,2), pelilauta);
        pelilauta.getPelialusta()[1][2].setNappula(p3);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (3,4), pelilauta);
        pelilauta.getRuutu(2, 3).setNappula(p4);
        assertEquals(false, p2.pystyykoSyomaan());
    }
     @Test
     public void syokoUudestaanToimiikuninkaillaKunPystyy(){
     Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (4,5), pelilauta);
     Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (3,4), pelilauta);
     Pelinappula p5 = new Pelinappula (PUNAINEN, new Lukupari (5,6), pelilauta);
     p3.teeKuningas();
     pelilauta.getRuutu(4, 5).setNappula(p3);
     pelilauta.getPelialusta()[3][4].setNappula(p4);
     pelilauta.getPelialusta()[5][6].setNappula(p5);
     assertEquals(true, p3.pystyykoSyomaan()); 
    }
     @Test
     public void syokoUudestaanToimiikuninkaillaKunEiPysty(){
     Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (4,5), pelilauta);
     Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (3,4), pelilauta);
     Pelinappula p5 = new Pelinappula (PUNAINEN, new Lukupari (5,6), pelilauta);
     p3.teeKuningas();
     pelilauta.getRuutu(4, 5).setNappula(p3);
     assertEquals(false, p3.pystyykoSyomaan()); 
    }
     
     @Test
    public void pystyykoLikkumaanToimiiKuninkailla(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (4,5), pelilauta);
        p3.teeKuningas();
        assertEquals(true, p3.pystyykoLiikkumaan());
    }
    @Test
    public void PystyykoLikkumaanToimiiValkoisilla(){
        assertEquals(true, p2.pystyykoLiikkumaan());
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (1,2), pelilauta);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (1,0), pelilauta);
        pelilauta.getRuutu(1, 2).setNappula(p4);
        pelilauta.getRuutu(1, 0).setNappula(p3);
        assertEquals(false, p2.pystyykoLiikkumaan());
    }
    @Test
    public void PystyykoLikkumaanToimiiPunaisilla(){
        assertEquals(true, p1.pystyykoLiikkumaan());
        Pelinappula p3 = new Pelinappula (VALKOINEN, new Lukupari (6,5), pelilauta);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (6,7), pelilauta);
        pelilauta.getRuutu(6, 5).setNappula(p4);
        pelilauta.getRuutu(6, 7).setNappula(p3);
        assertEquals(false, p1.pystyykoLiikkumaan());
    }
    @Test
    public void NappulaEiPystyLiikumaanKentanUlkopuolelle(){
        Pelinappula p3 = new Pelinappula (PUNAINEN, new Lukupari (6,5), pelilauta);
        Pelinappula p4 = new Pelinappula (PUNAINEN, new Lukupari (6,7), pelilauta);
        pelilauta.getRuutu(5, 6).setNappula(p4);
        pelilauta.getRuutu(6, 7).setNappula(p3);
        assertEquals(false, p3.pystyykoLiikkumaan());
    }
    @After
    public void tearDown() {
    }
}
