

package jalotammi.tammipeli;

import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import static java.lang.Math.random;
import java.util.Random;


public class Arpoja {
    Random rn;

    public Arpoja() {
         this.rn = new Random();
    }
    public Vari arvo(){
        int i = rn.nextInt(1);
        if(i==1){
            return PUNAINEN;
        }else{
            return VALKOINEN;
        }
    }
}
