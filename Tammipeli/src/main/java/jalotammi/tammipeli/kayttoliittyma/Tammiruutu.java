

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import jalotammi.tammipeli.domain.Pelinappula;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;


public class Tammiruutu extends JButton{
    private Ruutu ruutu;

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
    
    public void naytaNappula(){
        Pelinappula nappula = ruutu.getNappula();
        if(nappula == null){
            setText("");
        }else if(nappula.getVari() == PUNAINEN){
            setForeground(Color.red);
            if(nappula.isKuningas()){
                setText("KUN");
            }else{
                setText("PUN");
            }
        }else{
          setForeground(Color.white);
          if(nappula.isKuningas()){
                setText("KUN");
            }else{
                setText("VAL");
            }
        }
    } 

    /*@Override
    protected void paintComponent(Graphics g) {
    g.setColor(Color.BLUE);
    g.fillOval(getHorizontalAlignment(), getVerticalAlignment(), getWidth(), getHeight());//To change body of generated methods, choose Tools | Templates.
    }*/
    
}
