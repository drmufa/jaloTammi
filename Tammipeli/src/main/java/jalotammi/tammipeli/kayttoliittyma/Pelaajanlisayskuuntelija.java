/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.Arpoja;
import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelaava;
import jalotammi.tammipeli.tekoaly.Tietokonepelaaja;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *Luokka Lisaa Pelaajat pelin kun painetaan aloita pelipainiketta 
 * 
 */
public class Pelaajanlisayskuuntelija implements ActionListener{
    private JTextField nimiKentta;
    private JTextField nimiKentta2;
    private Frame frame;
    private Kayttoliittyma kl;

    public Pelaajanlisayskuuntelija(JTextField nimiKentta, JTextField nimiKentta2,
            Frame frame, Kayttoliittyma kl) {
        this.nimiKentta = nimiKentta;
        this.nimiKentta2 = nimiKentta2;
        this.frame = frame;
        this.kl = kl;
    }
    
     /**
     * Metodi lisää pelaajat, sulkee aloitus popup ikkunen ja paivittaa
     * kayttoliittyman kayttoliittyman omalla paivitaPeli() metodilla
     * 
     * @see Kayttoliittyma
     * 
     */ 
    @Override
    public void actionPerformed(ActionEvent e) {
        Pelaaja pelaaja1 = 
                new Pelaaja(this.nimiKentta.getText(), kl.getPelilauta());
        Pelaaja pelaaja2 = 
                new Pelaaja(this.nimiKentta2.getText(), kl.getPelilauta());
        kl.setPelaaja1(pelaaja1);
        kl.setPelaaja2(pelaaja2);
        Arpoja a = new Arpoja();
        Vari v = a.arvo();
        pelaaja1.setVari(v);
        if(v == VALKOINEN){
            pelaaja2.setVari(Vari.PUNAINEN);
            pelaaja2.setVuorossa(true);
        } else {
            pelaaja2.setVari(Vari.VALKOINEN);
            pelaaja1.setVuorossa(true);
        }
        frame.setVisible(false);
        kl.getPelilauta().uusiPeli();
        kl.paivitaPeli();
    }   
}
