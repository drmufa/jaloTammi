/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author jajnousi
 */
public class Ohjenapinkuuntelija implements ActionListener{
    private Kayttoliittyma kl;
    private JLabel ohje;

    public Ohjenapinkuuntelija(Kayttoliittyma kl, JLabel ohje) {
        this.kl = kl;
        this.ohje = ohje;
    }
    
    public void actionPerformed(ActionEvent e){
        ohje.setText(generoiTeksti());
    }
    public String generoiTeksti(){
        if(kl.getPelaaja1() == null){
            return "hah";
        }
        else if(kl.getPelaaja1().isVuorossa()){
            return pelaajan1auttaminen();
        }else{
            return pelaajan2auttaminen();
        }
    }

    private String pelaajan2auttaminen() {
        if(kl.getPelaaja2().getSyonyt() != null){
            return "jatka syömistä nappulalla: "
                    + kl.getPelaaja2().getSyonyt().toString();
        }else if(!kl.getPelaaja2().getSyovat().isEmpty()){
            return "Pakko syödä kun pystyy! "
                    + kl.getPelaaja2().getSyovat().toString();
        }else{
            return "come on!";
        }
    }

    private String pelaajan1auttaminen() {
        if(kl.getPelaaja1().getSyonyt() != null){
            return "jatka syömistä nappulalla: "
                    + kl.getPelaaja1().getSyonyt().toString();
        }else if(!kl.getPelaaja1().getSyovat().isEmpty()){
            return "Pakko syödä kun pystyy! "
                    + kl.getPelaaja1().getSyovat().toString();
        }else{
            return "come on!";
        }
    }
}
