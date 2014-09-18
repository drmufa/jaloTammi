

package jalotammi.tammipeli.domain;

import static jalotammi.tammipeli.domain.Vari.PUNAINEN;
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
     
     public boolean syoko(Ruutu syotava, Ruutu ruutu){
         boolean i;
         if(ruutu.getNappula() != null || syotava.getNappula()== null || 
                 syotava.getNappula().getVari().equals(this.vari)){
             i = false;
         }else if(kuningas == true){
             i = syokoKuningas(syotava, ruutu);
         }else if(vari.equals(VALKOINEN)){
             i = syokoValkoinen(syotava, ruutu);
         }else{
             i = syokoPunainen(syotava, ruutu);
         }
         return i;
     }
    
     private boolean kuningasLiikkuuko(Ruutu ruutu){
        if(((paikka.getX()== ruutu.getPaikka().getX() + 1)||
             (paikka.getX()== ruutu.getPaikka().getX() - 1))   
                 && ((paikka.getY()== ruutu.getPaikka().getY()+1)||
                 (paikka.getY()== ruutu.getPaikka().getY()-1))){
          return true;   
         }else{
        return false;
         }
    }
     private boolean valkoinenNappulaLiikkuuko(Ruutu ruutu){
         if(((paikka.getX()== ruutu.getPaikka().getX()-1)
                 && (paikka.getY()== ruutu.getPaikka().getY()+1))||
                 (paikka.getY()== ruutu.getPaikka().getY()-1)){
          return true;   
         }else{
        return false;
         }
    }
     private boolean punainenNappulaLiikkuuko(Ruutu ruutu){
         if((paikka.getX()== ruutu.getPaikka().getX()+1)
                 && ((paikka.getY()== ruutu.getPaikka().getY()+1)||
                 (paikka.getY() == ruutu.getPaikka().getY()-1))){
          return true;   
         }else{
        return false;
        }
    }
     
     private boolean syokoValkoinen(Ruutu syotava, Ruutu ruutu){
         if(((paikka.getX()== ruutu.getPaikka().getX()-2)
                 && (paikka.getY()== ruutu.getPaikka().getY()+2))&&
                 ((paikka.getX()== syotava.getPaikka().getX()-1)
                 && (paikka.getY()== syotava.getPaikka().getY()+1))){
          return true;
          }else if(((paikka.getX()== ruutu.getPaikka().getX()-2)
                 && (paikka.getY()== ruutu.getPaikka().getY()-2))&&
                 ((paikka.getX()== syotava.getPaikka().getX()-1)
                 && (paikka.getY()== syotava.getPaikka().getY()-1))){
          return true;
          }else{
         return false;
          }
     }
     
     private boolean syokoPunainen(Ruutu syotava, Ruutu ruutu){
         if(((paikka.getX()== ruutu.getPaikka().getX()+2)
                 && (paikka.getY()== ruutu.getPaikka().getY()+2))&&
                 ((paikka.getX()== syotava.getPaikka().getX()+1)
                 && (paikka.getY()== syotava.getPaikka().getY()+1))){
          return true;
          }else if(((paikka.getX()== ruutu.getPaikka().getX()+2)
                 && (paikka.getY()== ruutu.getPaikka().getY()-2))&&
                 ((paikka.getX()== syotava.getPaikka().getX()+1)
                 && (paikka.getY()== syotava.getPaikka().getY()-1))){
          return true;
          }else{
         return false;
          }
     }
     public boolean syokoKuningas(Ruutu syotava, Ruutu ruutu){
         if(syokoPunainen(syotava, ruutu) == true || syokoValkoinen(syotava, ruutu) == true){
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
    public Vari getVari(){
        return vari;
    }     
}

