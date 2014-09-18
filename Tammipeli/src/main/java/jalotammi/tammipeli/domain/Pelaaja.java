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
    private int nappuloitajaljella;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
        this.nappulat = new ArrayList<>();
        this.nappuloitajaljella = 12;
    }
    public void SiirraNappula(Pelinappula nappula, Ruutu ruutu){
        if(nappula.liikkuuko(ruutu) == true && nappula.getVari() == this.vari){
            ruutu.setNappula(nappula);
            nappula.setPaikka(ruutu.getPaikka());
        }        
    }public void setVari(Vari vari) {
        this.vari = vari;
    }
    public void nappulaSyoty(){
        nappuloitajaljella--;
    }
}
