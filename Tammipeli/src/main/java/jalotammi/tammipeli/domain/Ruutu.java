
package jalotammi.tammipeli.domain;


public class Ruutu {
    
    private Pelinappula nappula;
    private final Vari vari;
    private final Lukupari paikka;

    public Ruutu(Vari vari, Lukupari paikka) {
        this.vari = vari;
        this.paikka = paikka;
        this.nappula = null;
    }
  
    public void setNappula(Pelinappula nappula) {
        this.nappula = nappula;
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

    
}
