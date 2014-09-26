

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


public class Ruudunvalintakuuntelija implements ActionListener{
    private Lukupari paikka;
    private Pelilauta pl;
    private  JButton jb;
    private Kayttoliittyma kl;

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl) {
        this.paikka = paikka;
        this.pl = pl;
    }

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl, JButton jb) {
        this.paikka = paikka;
        this.pl = pl;
        this.jb = jb;
    }

    public Ruudunvalintakuuntelija(Lukupari paikka, Pelilauta pl, JButton jb, Kayttoliittyma kl) {
        this.paikka = paikka;
        this.pl = pl;
        this.jb = jb;
        this.kl = kl;
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Ruutu ruutu = pl.getPelialusta()[paikka.getX()][paikka.getY()];
        System.out.println(ruutu.toString());
        //jb.setForeground(Color.red);     
        //jb.setText("PUN");
        kl.paivita();
    }   
}
