/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import java.util.ArrayList;

public class Pelaaja {
    
    private String nimi;
    private ArrayList<Pelinappula> nappulat;
    private Vari vari;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
        this.nappulat = new ArrayList<>();
    }

    public void setVari(Vari vari) {
        this.vari = vari;
    }
    
}
