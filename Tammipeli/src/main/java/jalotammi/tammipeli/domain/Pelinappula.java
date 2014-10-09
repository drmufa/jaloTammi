

package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
import static jalotammi.tammipeli.Vari.PUNAINEN;
import static jalotammi.tammipeli.Vari.VALKOINEN;
/**
  * Luokka kertoo miten nappuloita voi liikuttaa sääntöjen puitteissa
  */ 

public class Pelinappula {
    private final Vari vari;
    private boolean kuningas;
    private Lukupari paikka;
    private Pelilauta pelilauta;

    public Pelinappula(Vari vari, Lukupari paikka, Pelilauta pelilauta) {
        this.vari = vari;
        this.kuningas = false;
        this.paikka = paikka;
        this.pelilauta = pelilauta;
    }


    public void teeKuningas() {
        this.kuningas = true;
    }
    /**
     * Metodi tarkistaa liikkuuko nappula pelaajan haluamaan ruutuun
     * 
     * @param ruutu kayttoliittymassa pelaajalle annettu ruutu, 
     * johon nappula halutaan siirtää
     */
     public boolean liikkuuko(Ruutu ruutu){
        boolean i;
        if(ruutu.getNappula() != null){
            i = false;
        }else if(kuningas == true){
             i = ylosJaAlaNappulaLiikkuuko(ruutu);
        }else if(vari.equals(VALKOINEN)){
             i = alasNappulaLiikkuuko(ruutu);            
        }else{
             i = ylosNappulaLiikkuuko(ruutu);
        }
        return i;
    }
     /**
     * Metodi tarkistaa syoko nappula pelaajan haluamalla tavalla
     * 
     * @param ruutu kayttoliittymassa pelaajalle annettu ruutu, 
     * johon nappula halutaan siirtää
     * 
     * @param syotava kayttoliittymassa pelaajalle annettu ruutu, 
     * josta halutaan syoda mahdollinen nappula
     */
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
    
     private boolean ylosJaAlaNappulaLiikkuuko(Ruutu ruutu){
        if(((paikka.getX()== ruutu.getPaikka().getX() + 1)||
             (paikka.getX()== ruutu.getPaikka().getX() - 1))   
                 && ((paikka.getY()== ruutu.getPaikka().getY()+1)||
                 (paikka.getY()== ruutu.getPaikka().getY()-1))){
          return true;   
         }else{
        return false;
         }
    }
     private boolean alasNappulaLiikkuuko(Ruutu ruutu){
         if(((paikka.getX()== ruutu.getPaikka().getX()-1)
                 && ((paikka.getY()== ruutu.getPaikka().getY()+1))||
                 (paikka.getY()== ruutu.getPaikka().getY()-1))){
          return true;   
         }else{
        return false;
         }
    }
     private boolean ylosNappulaLiikkuuko(Ruutu ruutu){
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
     private boolean syokoKuningas(Ruutu syotava, Ruutu ruutu){
         if(syokoPunainen(syotava, ruutu) == true || syokoValkoinen(syotava, ruutu) == true){
             return true;
         }else{
         return false;  
         }
     }
     /**
     * Metodi tarkistaa onko kyseinen nappula Kuningas eli liikkuuko se
     * ylä- ja alaviistoon
     *
     */
     public void tarkistaKuninkuus(){
         if(vari == PUNAINEN && paikka.getX() == 0){
             teeKuningas();
         }else if(vari == VALKOINEN && paikka.getX() == 7){
             teeKuningas();
         }
     }

    public void setPaikka(Lukupari paikka) {
        this.paikka = paikka;
    }

    public Lukupari getPaikka() {
        return paikka;
    }
    

    public boolean isKuningas() {
        return kuningas;
    }
    public Vari getVari(){
        return vari;
    }
    /**
     * Metodi tarkistaa pystyykö nappula syömään jonkun nappulan
     * 
     * @return paulauttaa true, jos pystyy syömään
     */ 
    public boolean pystyykoSyomaan(){
        int x = paikka.getX();
        int y = paikka.getY();
        boolean b;
        if(syotavatLahiRuudut(x, y, 1, 1) || syotavatLahiRuudut(x, y, 1, -1)||
        syotavatLahiRuudut(x, y, -1, 1)|| syotavatLahiRuudut(x, y, -1, -1)){
            return true;
        } else {
            return false;
        }
    }
    /**
     * Metodi tarkistaa pystyykö nappula liikumaan johonkin
     * 
     * @return paulauttaa true, jos pystyy
     */ 
    public boolean pystyykoLiikkumaan(){
        int x = paikka.getX();
        int y = paikka.getY();
        boolean b;
        if(liikuttavatLahiRuudut(x, y, 1, 1) || liikuttavatLahiRuudut(x, y, 1, -1)||
                liikuttavatLahiRuudut(x, y, -1, 1)|| liikuttavatLahiRuudut(x, y, -1, -1)){
            return true;
        } else {
            return false;
        }
    }

    private boolean syotavatLahiRuudut(int x, int y, int z, int v) {
        boolean b = false;
        try{
            b = syoko(pelilauta.getRuutu(x+z, y+v),pelilauta.getRuutu(x+(2*z), y+(2*v)));
        }catch(Exception e){        
    }return b;
    }
    
    private boolean liikuttavatLahiRuudut(int x, int y, int z, int v) {
        boolean b = false;
        try{
            b = liikkuuko(pelilauta.getRuutu(x+z, y+v));
        }catch(Exception e){        
    }return b;
    }

    @Override
    public String toString() {
        return  paikka.toString();
    }    
}

