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
    private int nappuloitasyoty;
    private int siirrot;
    private boolean vuorossa;
    private Pelilauta pl;
    
    public Pelaaja(String nimi, Pelilauta pl){
        this.nimi = nimi;
        this.nappulat = new ArrayList<Pelinappula>();
        this.nappuloitasyoty = 0;
        this.siirrot = 0;
        this.vuorossa = false;
        this.pl = pl;
    }
    /**
     * Metodi lisaa pelissa olevat oikean väriset nappulat
     * pelaajan Naapulat listalle
     */
    public void lisaaNappulat(){
        for (Ruutu[] ruudut : pl.getPelialusta()) {
            for (Ruutu ruutu : ruudut) {
                if(ruutu.getNappula() != null && 
                        ruutu.getNappula().getVari() == vari){
                    nappulat.add(ruutu.getNappula());
                }
            }
        }
    }
    /**
    * Metodi liikuttaa nappulaa valitusta lahto ruudusta valittuun maali
    * ruutuun, jos se on sääntöjen puitteissa mahdollista
    * @param lahto kayttoliittyman kautta valittu ruutu
    * @param vali kayttoliittyman kautta valittu ruutu
    * @param maali kayttoliittyman kautta valittu ruutu
    */
    
    public void liikutaNappulaa(Ruutu lahto, Ruutu vali, Ruutu maali){
        if(vali == maali){
            siirraNappula(lahto,vali);
        }else{
            syoNappulalla(lahto,vali,maali);
        }
        if(maali.getNappula() !=null){
            maali.getNappula().tarkistaKuninkuus();
        }
    }
    
    private void siirraNappula(Ruutu lahto, Ruutu maali){
        Pelinappula n = lahto.getNappula();
        if(n == null||n.getVari()!= this.vari){
        }
        else if(n.liikkuuko(maali) == true){
            maali.setNappula(n);
            lahto.tyhjennaRuutu();
            siirrot++;
            vuorossa = false;
        }else{
        }
    }
    
    private void syoNappulalla(Ruutu lahto, Ruutu syotava, Ruutu maali){
        Pelinappula n = lahto.getNappula();
        if(n==null||n.getVari()!= this.vari){
        }
        else
        if(n.syoko(syotava, maali) == true){
            maali.setNappula(n);
            lahto.tyhjennaRuutu();
            syotava.tyhjennaRuutu();
            siirrot++;
            nappuloitasyoty++;
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

    public void setVuorossa(boolean vuorossa) {
        this.vuorossa = vuorossa;
    }

    public boolean isVuorossa() {
        return vuorossa;
    }

    public int getNappuloitasyoty() {
        return nappuloitasyoty;
    }
    
    @Override
    public String toString() {
        if(vari == null){
            return nimi;
        }
        return nimi + " (" + vari.toString()+ ")";
    }
     
}
