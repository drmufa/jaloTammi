/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
import java.util.ArrayList;

public class Pelaaja {
    
    private String nimi;
    private ArrayList<Pelinappula> nappulat;
    private Vari vari;
    private int nappuloitajaljella;
    private int siirrot;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
        this.nappulat = new ArrayList<>();
        this.nappuloitajaljella = 12;
        this.siirrot = 0;
    }
    public void SiirraNappula(Ruutu lahto, Ruutu ruutu){
        if(lahto.getNappula() == null){
            return;
        }
        else if(lahto.getNappula().liikkuuko(ruutu) == 
                true && lahto.getNappula().getVari() == this.vari){
            ruutu.setNappula(lahto.getNappula());
            lahto.tyhjennaRuutu();
            siirrot++;
        }else{
            return;
        }
    }
    public void syoNappulalla(Ruutu lahto, Ruutu syotava, Ruutu ruutu){
        if(lahto.getNappula()==null){
            return;
        }
        else
        if(lahto.getNappula().syoko(syotava, ruutu) == 
                true && lahto.getNappula().getVari() == this.vari){
            ruutu.setNappula(lahto.getNappula());
            lahto.tyhjennaRuutu();
            syotava.tyhjennaRuutu();
            siirrot++;
        }else{
            return;
        }
    }

    public int getSiirrot() {
        return siirrot;
    }
    
    public void setVari(Vari vari) {
        this.vari = vari;
    }
    public void nappulaSyoty(){
        nappuloitajaljella--;
    }
}
