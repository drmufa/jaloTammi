

package jalotammi.tammipeli.domain;

import static jalotammi.tammipeli.Vari.MUSTA;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import java.util.ArrayList;
/**
 * Luokka toimii pelialustana pelille. Kertoo ruutujen paikat.
 * 
 */
public class Pelilauta {
    private Ruutu[][] pelialusta;

     /**
     * Metodi luo pelilaudan, joka koostuu ruuduista, joista jokatoinen on 
     * musta ja joka toinen valkoinen.
     */
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
    /**
     * Metodi lisaa Pelinappulat pelilaudalle. Valkoiset asettuvat mustille
     * ruuduille ensimmäiselle kolmelle riville ja punaiset taas komelle 
     * viimeiselle riville
     */
    public void lisaaPeliNappulat(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2 != 0){
                    pelialusta[i][j].setNappula(new Pelinappula(VALKOINEN, new Lukupari(i,j), this));
                }                
            }           
        }
        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i+j)%2 != 0){
                    pelialusta[i][j].setNappula(new Pelinappula(PUNAINEN, new Lukupari(i,j), this));
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
    private void tyhjennaRuudut(){
        for (Ruutu[] ruutus : pelialusta) {
            for (Ruutu ruutu : ruutus) {
                ruutu.tyhjennaRuutu();
            }
        }
    }
    public void uusiPeli(){
        tyhjennaRuudut();
        this.lisaaPeliNappulat();
    }
}
