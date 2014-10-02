

package jalotammi.tammipeli.domain;

import static jalotammi.tammipeli.Vari.MUSTA;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import java.util.ArrayList;

public class Pelilauta {
    private final Ruutu[][] pelialusta;

    public Pelilauta() {
        this.pelialusta = new Ruutu[8][8];
        this.lisaaRuudut();
    }
    
    private void lisaaRuudut(){
    for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2 == 0){
                   pelialusta[i][j] = new Ruutu(VALKOINEN, new Lukupari(i,j)); 
                } else{
                   pelialusta[i][j] = new Ruutu(MUSTA, new Lukupari(i,j));
                }                              
            }
        }
    }
    public void lisaaPeliNappulat(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2 != 0){
                    pelialusta[i][j].setNappula(new Pelinappula(VALKOINEN, new Lukupari(i,j)));
                }                
            }           
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2 != 0){
                    pelialusta[i][j].setNappula(new Pelinappula(PUNAINEN, new Lukupari(i,j)));
                }                 
            }           
        }
    }
    
    public Ruutu[][] getPelialusta() {
        return pelialusta;
    }
    public Ruutu getRuutu(int i, int j){
        return this.pelialusta[i][j];
    }    
}
