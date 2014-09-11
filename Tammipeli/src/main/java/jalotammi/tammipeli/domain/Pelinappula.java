

package jalotammi.tammipeli.domain;

import static jalotammi.tammipeli.domain.Vari.VALKOINEN;


public class Pelinappula {
    private final Vari vari;
    private boolean kuningas;
    private Lukupari paikka;

    public Pelinappula(Vari vari, Lukupari paikka) {
        this.vari = vari;
        this.kuningas = false;
        this.paikka = paikka;
    }


    public void teeKuningas() {
        this.kuningas = true;
    }
    
    public boolean liikkuuko(Ruutu ruutu){
        boolean i;
        if(ruutu.getNappula() != null){
            i = false;
        }else if(kuningas == true){
             i = kuningasLiikkuuko(ruutu);
        }else if(vari.equals(VALKOINEN)){
             i = valkoinenNappulaLiikkuuko(ruutu);            
        }else{
             i = punainenNappulaLiikkuuko(ruutu);
        }
        return i;
    }
    
    public boolean kuningasLiikkuuko(Ruutu ruutu){
        if(((paikka.getX()== ruutu.getPaikka().getX() + 1)||
             (paikka.getX()== ruutu.getPaikka().getX() - 1))   
                 && ((paikka.getY()== ruutu.getPaikka().getY()+1)||
                 (paikka.getY()== ruutu.getPaikka().getY()-1))){
          return true;   
         }else{
        return false;
         }
    }
     public boolean valkoinenNappulaLiikkuuko(Ruutu ruutu){
         if(((paikka.getX()== ruutu.getPaikka().getX()-1)
                 && (paikka.getY()== ruutu.getPaikka().getY()+1))||
                 (paikka.getY()== ruutu.getPaikka().getY()-1)){
          return true;   
         }else{
        return false;
         }
    }
     public boolean punainenNappulaLiikkuuko(Ruutu ruutu){
         if((paikka.getX()== ruutu.getPaikka().getX()+1)
                 && ((paikka.getY()== ruutu.getPaikka().getY()+1)||
                 (paikka.getY() == ruutu.getPaikka().getY()-1))){
          return true;   
         }else{
        return false;
        }
    }

    public void setPaikka(Lukupari paikka) {
        this.paikka = paikka;
    }

    public boolean isKuningas() {
        return kuningas;
    }
    


     
}

