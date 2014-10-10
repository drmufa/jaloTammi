/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.kayttoliittyma;

import javax.swing.JLabel;
/**
 *Luokka Luo Pelaajille ohje tekstin, joka kertoo mm. kenen vuoro on. 
 * 
 */

public class Tekstigeneraattori {
    
    private JLabel teksti;
    private Kayttoliittyma kl;

    public Tekstigeneraattori(JLabel teksti, Kayttoliittyma kl) {
        this.kl = kl;
        this.teksti = teksti;
    }
    
    public void muutaTekstia(String huomautus){
        teksti.setText(huomautus);
    }
    public void muutaTekstia(){
        teksti.setText(teeTeksti());
    }
    /**
      *Metodi kirjoittaa tekstin tarpeen mukaan
      */
    public String teeTeksti(){
        if(kl.getPelaaja1().getNappuloitasyoty() == 12 ){
            return "VOITTAJA: " + kl.getPelaaja1().toString();
        }else if(kl.getPelaaja2().getNappuloitasyoty() == 12 ){
           return "VOITTAJA: " + kl.getPelaaja2().toString();
        }else{
           return teeVuoroTeksti(); 
        }
    }

    private String teeVuoroTeksti() {
        if(kl.getPelaaja1().isVuorossa()){
            return kl.getPelaaja1().toString();
        }else{
            return kl.getPelaaja2().toString();
        }
    }
}
