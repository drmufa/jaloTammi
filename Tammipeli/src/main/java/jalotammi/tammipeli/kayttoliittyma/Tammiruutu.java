

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import jalotammi.tammipeli.domain.Pelinappula;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Tammiruutu extends JButton{
    private Ruutu ruutu;
    private static ImageIcon punainennappula = 
            new ImageIcon("/tammipeli/domain/punainenNappula.png");
    private static ImageIcon valkoinennappula = 
            new ImageIcon("/home/jajnousi/jaloTammi/Tammipeli/src/main/java/jalotammi/tammipeli/domain/valkoinenNappula.png");
    private static ImageIcon valkoinenkunkkunappula = 
            new ImageIcon("/home/jajnousi/jaloTammi/Tammipeli/src/main/java/jalotammi/tammipeli/domain/valkoinenKuningasNappula.png");
    private static ImageIcon punainenkunkkunappula = 
            new ImageIcon("/home/jajnousi/jaloTammi/Tammipeli/src/main/java/jalotammi/tammipeli/domain/punainenKuningasNappula.png");
    
    
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
