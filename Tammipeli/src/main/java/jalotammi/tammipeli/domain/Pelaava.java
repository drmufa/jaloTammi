

package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
import java.util.ArrayList;

public interface Pelaava {
    boolean alustaVuoro();
    boolean isVuorossa();
    void liikutaNappulaa(Ruutu lahto, Ruutu vali, Ruutu maali);
    void setVari(Vari vari);
    void setVuorossa(boolean vuorossa);
    void pelaa();
    ArrayList<Pelinappula> getSyovat();
    Pelinappula getSyonyt();
    int getNappuloitasyoty();
    int getSiirrot();
}
