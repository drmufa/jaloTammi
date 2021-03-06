
package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
/**
  * Pelaaja käyttää luokan Ruutu olioita nappuloiden siirtämiseen
  */ 

public class Ruutu {
    
    private Pelinappula nappula;
    private final Vari vari;
    private final Lukupari paikka;
    private static final String aakkoset = "ABCDEFGH";

    public Ruutu(Vari vari, Lukupari paikka) {
        this.vari = vari;
        this.paikka = paikka;
        this.nappula = null;
    }
  
    public void setNappula(Pelinappula nappula) {
        this.nappula = nappula;
        nappula.setPaikka(paikka);
    }
    
    public void tyhjennaRuutu(){
        this.nappula = null;
    }

    public Vari getVari() {
        return vari;
    }

    public Lukupari getPaikka() {
        return paikka;
    }

    public Pelinappula getNappula() {
        return nappula;
    }

    @Override
    public String toString() {
        if(nappula == null){
           return "ruutu: " + paikka.toString() + ", ei nappulaa"; 
        }else {
           return "ruutu: " + paikka.toString() + ", " + nappula.getVari().toString(); 
        }
    }     
}
