

package jalotammi.tammipeli.tekoaly;

import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelinappula;
import jalotammi.tammipeli.domain.Ruutu;
import java.util.ArrayList;
import java.util.Random;

/**
 * 
 * Luokka ei vielä käytössä.
 * 
 * luokka arpoo mahddollisa siirtoja tietokonepelaajalle.
 */
public class Ruutuarpoja {
    Random rn;
    Tietokonepelaaja tietokonepelaaja;

    public Ruutuarpoja(Tietokonepelaaja tietokonepelaaja) {
         this.rn = new Random();
         this.tietokonepelaaja = tietokonepelaaja;
    }
    public Lukupari arvoLukuPari(){
        int i = rn.nextInt(5);
        int x;
        int y;
        switch(i){
            case 0: x = 1;
                    y = 1;
                    break;
            case 1: x = 1;
                    y = -1;
                    break;
            case 2: x = -1;
                    y = 1;
                    break;
            default:x = -1;
                    y = -1;    
        }
        return new Lukupari(x,y);
    }
    public Ruutu arvoLahtoRuutu(ArrayList<Pelinappula> lista){        
        int i = rn.nextInt(lista.size());
        Pelinappula n = lista.get(i);
        Lukupari paikka = n.getPaikka();
        return tietokonepelaaja.getPl().getRuutu(paikka.getX(), paikka.getY());
    }
    
    public ArrayList<Ruutu> arvoMaaliSyontiRuutu(Ruutu lahto){
        ArrayList<Ruutu> Ruudut = new ArrayList<Ruutu>();
        Ruutu maali = null;
        Ruutu vali = null;
        int x = lahto.getPaikka().getX();
        int y = lahto.getPaikka().getX();
        int z = this.arvoLukuPari().getX();
        int v = this.arvoLukuPari().getY();
        try{
            Ruutu maalitesti = tietokonepelaaja.getPl().getRuutu(x+(2*z), y+(2*v));
            Ruutu valitesti = tietokonepelaaja.getPl().getRuutu(x+z, y+v);
            if(lahto.getNappula().syoko(valitesti, maalitesti)){
                maali = maalitesti;
                vali = valitesti;
                Ruudut.add(maali);
                Ruudut.add(vali);
            }else{
                arvoMaaliSyontiRuutu(lahto);
            }
        }catch(Exception e){
            arvoMaaliSyontiRuutu(lahto);
    }return Ruudut;
    }
    
    public Ruutu arvoMaaliLiikkumisRuutu(Ruutu lahto){
        Ruutu maali = null;
        int x = lahto.getPaikka().getX();
        int y = lahto.getPaikka().getX();
        int z = this.arvoLukuPari().getX();
        int v = this.arvoLukuPari().getY();
        try{
            Ruutu maalitesti = tietokonepelaaja.getPl().getRuutu(x+z, y+v);
            if(lahto.getNappula().liikkuuko(maalitesti)){
                maali = maalitesti;               
            }else{
                arvoMaaliSyontiRuutu(lahto);
            }
        }catch(Exception e){ 
            arvoMaaliSyontiRuutu(lahto);
    }return maali;
    }
    
}
