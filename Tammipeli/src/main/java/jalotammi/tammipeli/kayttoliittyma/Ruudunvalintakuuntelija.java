

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;


public class Ruudunvalintakuuntelija implements ActionListener{
    private Lukupari paikka;
    private Pelilauta pl;
    private Tammiruutu tm;
    private Kayttoliittyma kl;

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl) {
        this.paikka = paikka;
        this.pl = pl;
    }

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl, Tammiruutu tm) {
        this.paikka = paikka;
        this.pl = pl;
        this.tm = tm;
    }

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl, Tammiruutu tm, Kayttoliittyma kl) {
        this.paikka = paikka;
        this.pl = pl;
        this.tm = tm;
        this.kl = kl;
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
       Ruutu ruutu = tm.getRuutu();
       System.out.println(ruutu.toString());
       if(kl.getValittu() == null){
         kl.setValittu(tm);  
       } else {
           kl.getPelaaja1().SiirraNappula(kl.getValittu().getRuutu(), ruutu);
       }
        kl.paivitaPeli();
    }   
}
