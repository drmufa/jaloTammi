

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelinappula;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Tammiruutu extends JButton{
    private Ruutu ruutu;
    private static ImageIcon punainennappula = 
            createImageIcon("punainenNappula.png", "PUN");
    private static ImageIcon valkoinennappula = 
            createImageIcon("valkoinenNappula.png", "VAL");
    private static ImageIcon valkoinenkunkkunappula = 
            createImageIcon("valkoinenKuningasNappula.png", "VALKK");
    private static ImageIcon punainenkunkkunappula = 
            createImageIcon("punainenKuningasNappula.png", "PUNK");
    
    protected static ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = Pelaaja.class.getResource(path);
        if (imgURL != null) {
        return new ImageIcon(imgURL, description);
        } else {
        System.err.println("Couldn't find file: " + path);
        return null;
        }
    }
    
    public Tammiruutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Ruutu getRuutu() {
        return ruutu;
    }
    
    public void maalaaRuutu(){
        if(ruutu.getVari() == Vari.VALKOINEN){
            setBackground(Color.LIGHT_GRAY);
        }else{
            setBackground(Color.BLACK);
        }
    }
    /**
      *Metodi piirtää tammiruudulle nappulan ilmentymän ja palautaa ruudun
      * alkuperäisen väriseksi, jos se on ollut valittuna
      * 
      */
    public void naytaNappula(){
        Pelinappula nappula = ruutu.getNappula();
        if(nappula == null){
            setText("");
            setIcon(null);
        }else if(nappula.getVari() == PUNAINEN){
          maalaaPunainenNappula(nappula);
        }else{
          maalaaValkoinenNappula(nappula);
        }
    } 

    private void maalaaValkoinenNappula(Pelinappula nappula) {
        setForeground(Color.white);
        if(nappula.isKuningas()){
            setIcon(valkoinenkunkkunappula);
            this.setVisible(true);
        }else{
            //setText("VAL");
            setIcon(valkoinennappula);
            this.setVisible(true);
        }
    }

    private void maalaaPunainenNappula(Pelinappula nappula) {
        setForeground(Color.red);
        if(nappula.isKuningas()){
            setIcon(punainenkunkkunappula);
            this.setVisible(true);
        }else{
            //setText("PUN");
            setIcon(punainennappula);
            this.setVisible(true);
        }
    }
    
}
