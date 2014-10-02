

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *Luokka valitsee ruutuja joista/joihin vuorossa oleva pelaaja
 * siirtää nappuoita
 * 
 */

public class Ruudunvalintakuuntelija implements ActionListener{
    private Lukupari paikka;
    private Pelilauta pl;
    private Tammiruutu tm;
    private Kayttoliittyma kl;
    private Pelaaja p1;
    private Pelaaja p2;

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl, Tammiruutu tm, Kayttoliittyma kl) {
        this.paikka = paikka;
        this.pl = pl;
        this.tm = tm;
        this.kl = kl;
        this.p1 = kl.getPelaaja1();
        this.p2 = kl.getPelaaja2();
    }
    /**
      *Metodi valitsee painettuun tammiruutuun liitetyn ruudun valituksi tai 
      * valituksi2 tai jos molemmat on jo olemassa niin metodi käskee vuorossa 
      * olevaa pelaajaa siirtämään nappulan ensiksi valitusta ruudusta
      * painettuun ruutuun
      * 
      */
    @Override
    public void actionPerformed(ActionEvent e) {
       paivitaPelaajat();
       Ruutu ruutu = tm.getRuutu();
       System.out.println(ruutu.toString());
       if(p1 == null || p2 == null){
           System.out.println("Peli ei ole alkanut");
       }else if(p1.isVuorossa()){
          siirraNappulaaP1(ruutu);
       }else{
          siirraNappulaaP2(ruutu);
       }
    }   

    private void paivitaPelaajat() {
        p1 = kl.getPelaaja1();
        p2 = kl.getPelaaja2();
    }

    private void siirraNappulaaP1(Ruutu ruutu) {
        if(kl.getValittu() == null){
            kl.setValittu(tm);
        }else if(kl.getValittu2() == null){
            kl.setValittu2(tm);
        } else {
            p1.liikutaNappulaa(kl.getValittu().getRuutu(), 
                    kl.getValittu2().getRuutu(), ruutu);
            if(!p1.isVuorossa()){
                p2.setVuorossa(true);
            }
            kl.setValittu(null);
            kl.setValittu2(null);
        }
        kl.paivitaPeli();
    }
    
    private void siirraNappulaaP2(Ruutu ruutu) {
        if(kl.getValittu() == null){
            kl.setValittu(tm);
        }else if(kl.getValittu2() == null){
            kl.setValittu2(tm);
        } else {
            p2.liikutaNappulaa(kl.getValittu().getRuutu(), 
                    kl.getValittu2().getRuutu(), ruutu);
            if(!p2.isVuorossa()){
                p1.setVuorossa(true);
            } else {
            }
            kl.setValittu(null);
            kl.setValittu2(null);
        }
        kl.paivitaPeli();
    }
}
