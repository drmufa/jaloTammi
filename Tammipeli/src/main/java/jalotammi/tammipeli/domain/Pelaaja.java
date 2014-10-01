/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
import java.util.ArrayList;

public class Pelaaja {
    
    private final String nimi;
    private ArrayList<Pelinappula> nappulat;
    private Vari vari;
    private int nappuloitajaljella;
    private int siirrot;
    private boolean vuorossa;
    //private Pelilauta pl;
    
    public Pelaaja(String nimi){
        this.nimi = nimi;
        this.nappulat = new ArrayList<>();
        this.nappuloitajaljella = 12;
        this.siirrot = 0;
        this.vuorossa = false;
        //this.pl = pl;
    }
    public void LiikutaNappulaa(Ruutu lahto , Ruutu vali, Ruutu maali){
        if(vali == maali){
            SiirraNappula(lahto,vali);
        }else{
            syoNappulalla(lahto,vali,maali);
        }
        if(maali.getNappula() !=null){
            maali.getNappula().tarkistaKuninkuus();
        }
    }
    
    public void SiirraNappula(Ruutu lahto, Ruutu ruutu){
        Pelinappula n = lahto.getNappula();
        if(n == null||n.getVari()!= this.vari){
        }
        else if(n.liikkuuko(ruutu) == true){
            ruutu.setNappula(n);
            lahto.tyhjennaRuutu();
            siirrot++;
            vuorossa = false;
        }else{
        }
    }
    
    public void syoNappulalla(Ruutu lahto, Ruutu syotava, Ruutu ruutu){
        Pelinappula n = lahto.getNappula();
        if(n==null||n.getVari()!= this.vari){
        }
        else
        if(n.syoko(syotava, ruutu) == true){
            ruutu.setNappula(n);
            lahto.tyhjennaRuutu();
            syotava.tyhjennaRuutu();
            siirrot++;
            vuorossa = false;
        }else{
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

    public void setVuorossa(boolean vuorossa) {
        this.vuorossa = vuorossa;
    }

    public boolean isVuorossa() {
        return vuorossa;
    }
    

    @Override
    public String toString() {
        if(vari == null){
            return nimi;
        }
        return nimi + " " + vari.toString();
    }
     
}
