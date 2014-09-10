

package jalotammi.tammipeli.domain;

import static jalotammi.tammipeli.domain.Vari.RUSKEA;
import static jalotammi.tammipeli.domain.Vari.VALKOINEN;
import java.util.ArrayList;

public class Pelilauta {
    private final ArrayList[][] pelilauta;

    public Pelilauta() {
        this.pelilauta = new ArrayList[10][10];
        this.lisaaRuudut();
    }
    
    private void lisaaRuudut(){
    for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if((i+j)%2 == 0){
                   pelilauta[i][j].add(new Ruutu(VALKOINEN)); 
                } else{
                   pelilauta[i][j].add(new Ruutu(RUSKEA));
                }                              
            }
        }
    }
}
