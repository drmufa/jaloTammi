/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import jalotammi.tammipeli.Vari;
import jalotammi.tammipeli.kayttoliittyma.Tekstigeneraattori;
import java.util.ArrayList;

public class Pelaaja implements Pelaava{
    
    private final String nimi;
    private ArrayList<Pelinappula> nappulat;
    private ArrayList<Pelinappula> syovat;
    private Pelinappula syonyt;
    private Vari vari;
    private int nappuloitasyoty;
    private int siirrot;
    private boolean vuorossa;
    private Pelilauta pl;

    
    public Pelaaja(String nimi, Pelilauta pl){
        this.nimi = nimi;
        this.nappulat = new ArrayList<Pelinappula>();
        this.syovat = new ArrayList<Pelinappula>();
        this.nappuloitasyoty = 0;
        this.siirrot = 0;
        this.vuorossa = false;
        this.pl = pl;
    }
    /**
     * Metodi lisaa pelissa olevat oikean väriset nappulat
     * pelaajan Naapulat listalle
     */
    public void listaaNappulat(){
        nappulat.clear();
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
     * Metodi alustaa vuoronlistaamalla pelissä olevat nappulat ja 
     * ja syömiseen kykenevät nappulat.
     * 
     * @return Boolean -arvon siitä pystyykö pelaaja tekemään vielä siirtoja
     */
    
    public boolean alustaVuoro(){
        listaaNappulat();
        listaaSyovat();
        vuorossa = true;
        return pystyykoJatkamaanPelia();
    }
    
    private void listaaSyovat(){
        syovat.clear();
        for (Pelinappula pelinappula : nappulat) {
            if(pelinappula.pystyykoSyomaan()){
                syovat.add(pelinappula);
            }
        }
    }
    private boolean pystyykoJatkamaanPelia(){
        boolean i = false;
        for (Pelinappula pelinappula : nappulat) {
            if(pelinappula.pystyykoLiikkumaan()){
                i = true;
            } 
        }
        return i;
    }
    /**
    * Metodi liikuttaa nappulaa valitusta lahto ruudusta valittuun maali
    * ruutuun, jos se on sääntöjen puitteissa mahdollista ja jos on niin luovuttaa
    * vuoron ja siirtää nappulat pelialustalla
    * @param lahto kayttoliittyman kautta valittu ruutu
    * @param vali kayttoliittyman kautta valittu ruutu
    * @param maali kayttoliittyman kautta valittu ruutu
    */
    
    public void liikutaNappulaa(Ruutu lahto, Ruutu vali, Ruutu maali){
        if(vali == maali && syovat.isEmpty()){
            siirraNappula(lahto,vali);
        }else{
            syoNappulalla(lahto,vali,maali);
        }
        if(maali.getNappula() !=null){
            maali.getNappula().tarkistaKuninkuus();
        }
    }
    
    public void siirraNappula(Ruutu lahto, Ruutu maali){
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
        if(n==null||n.getVari()!= this.vari || (syonyt != null && syonyt != n)){
        }
        else if(n.syoko(syotava, maali) == true){
            teeSyontiSiirto(maali, n, lahto, syotava);
        }
    }

    private void teeSyontiSiirto(Ruutu maali, Pelinappula n, Ruutu lahto, Ruutu syotava) {
        maali.setNappula(n);
        lahto.tyhjennaRuutu();
        syotava.tyhjennaRuutu();
        siirrot++;
        nappuloitasyoty++;
        if(maali.getNappula().pystyykoSyomaan()){
            syonyt = maali.getNappula();
        }else{
            vuorossa = false;
            setSyonyt(null);
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

    public void setSyonyt(Pelinappula syonyt) {
        this.syonyt = syonyt;
    }

    public ArrayList<Pelinappula> getSyovat() {
        return syovat;
    }

    public ArrayList<Pelinappula> getNappulat() {
        return nappulat;
    }

    public Pelinappula getSyonyt() {
        return syonyt;
    }
    
    
    @Override
    public String toString() {
        if(vari == null){
            return nimi;
        }
        return nimi + " (" + vari.toString()+ ")";
    }

    public void pelaa() {
        System.out.println("Tee siirto "+ this.toString());
    }    
}
