/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.kayttoliittyma;

import javax.swing.JLabel;


public class Tekstigeneraattori {
    
    private JLabel teksti;
    private Kayttoliittyma kl;

    public Tekstigeneraattori(JLabel teksti, Kayttoliittyma kl) {
        this.kl = kl;
        this.teksti = teksti;
    }
    
    public void muutaTekstia(){
        teksti.setText(teeTeksti());
    }
    
    public String teeTeksti(){
        if(kl.getPelaaja1().getNappuloitasyoty() == 12 ){
            return "VOITTAJA:" + kl.getPelaaja1().toString();
        }else if(kl.getPelaaja2().getNappuloitasyoty() == 12 ){
           return "VOITTAJA:" + kl.getPelaaja2().toString();
        }else{
           return teeVuoroTeksti(); 
        }
    }

    private String teeVuoroTeksti() {
        if(kl.getPelaaja1().isVuorossa()){
            return kl.getPelaaja1().toString() + " vuorossa";
        }else{
            return kl.getPelaaja2().toString() + " vuorossa";
        }
    }
}
