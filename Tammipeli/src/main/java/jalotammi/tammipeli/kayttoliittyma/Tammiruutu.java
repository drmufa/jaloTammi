

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import jalotammi.tammipeli.domain.Pelinappula;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.Color;
import javax.swing.JButton;


public class Tammiruutu extends JButton{
    private Ruutu ruutu;

    public Tammiruutu(Ruutu ruutu) {
        this.ruutu = ruutu;
    }
    
    public Ruutu getRuutu() {
        return ruutu;
    }
    public void naytaNappula(){
        Pelinappula nappula = ruutu.getNappula();
        if(nappula == null){
        }else if(nappula.getVari() == PUNAINEN){
            setForeground(Color.red);
            setText("PUN");
        }else{
          setForeground(Color.white);
          setText("VAL"); 
        }
    }    
}
