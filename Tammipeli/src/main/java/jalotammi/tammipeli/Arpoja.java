

package jalotammi.tammipeli;

import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import static java.lang.Math.random;
import java.util.Random;

/**
 * 
 * Luokkaa käytetään pelin aloittajan arpomiseen.
 */

public class Arpoja {
    Random rn;

    public Arpoja() {
         this.rn = new Random();
    }
    /**
     * metodi arpoo kumpi aloitaa pelin eli pelaa punaisilla
     * 
     * @return Pelaajan värin pelissä 
     */
    public Vari arvo(){
        boolean i = rn.nextBoolean();
        if(i==true){
            return PUNAINEN;
        }else{
            return VALKOINEN;
        }
    }
}
