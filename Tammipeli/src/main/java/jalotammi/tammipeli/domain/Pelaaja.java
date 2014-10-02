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
        this.nappulat = new ArrayList<>();
        this.nappuloitasyoty = 0;
        this.siirrot = 0;
        this.vuorossa = false;
        this.pl = pl;
    }
    
    public void liikutaNappulaa(Ruutu lahto, Ruutu vali, Ruutu maali){
        if(vali == maali){
            SiirraNappula(lahto,vali);
        }else{
            syoNappulalla(lahto,vali,maali);
        }
        if(maali.getNappula() !=null){
            maali.getNappula().tarkistaKuninkuus();
        }
    }
    
    public void SiirraNappula(Ruutu lahto, Ruutu maali){
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
    
    public void syoNappulalla(Ruutu lahto, Ruutu syotava, Ruutu maali){
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
    
    public boolean syoko(Ruutu lahto){
        Pelinappula nappula = lahto.getNappula();
        int x = nappula.getPaikka().getX();
        int y = lahto.getPaikka().getY();
        int syontimahdollisuudet = 0;
        syontimahdollisuudet = tarkistaSytotavatruudut(x, y, nappula, syontimahdollisuudet);
        syontimahdollisuudet = tarkistaSyotavatRuudutToinensuunta(x, y, nappula, syontimahdollisuudet);
        if(syontimahdollisuudet == 0){
            return false;
        }else{
            return true;
        }
    }

    private int tarkistaSyotavatRuudutToinensuunta(int x, int y, Pelinappula nappula, int syontimahdollisuudet) {
        for (int i = 0; i < 3; i = i+1) {
            try{
                Ruutu syotava = pl.getRuutu(x-1+i,y+1-i);
                Ruutu maali = pl.getRuutu(x-2+2*i,y+2-2*i);
                if(nappula.syoko(syotava, maali)){
                    syontimahdollisuudet++;
                }
            }catch (Exception e){
            }
        }
        return syontimahdollisuudet;
    }

    private int tarkistaSytotavatruudut(int x, int y, Pelinappula nappula, int syontimahdollisuudet) {
        for (int i = 0; i < 3; i = i+1) {
            try{
                Ruutu syotava = pl.getRuutu(x-1+i,y-1+i);
                Ruutu maali = pl.getRuutu(x-2+2*i,y-2+2*i);
                if(nappula.syoko(syotava, maali)){
                    syontimahdollisuudet++;
                }
            } catch(Exception e) {
            }
        }
        return syontimahdollisuudet;
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
