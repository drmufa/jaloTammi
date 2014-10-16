

package jalotammi.tammipeli.tekoaly;

import jalotammi.tammipeli.Vari;
import jalotammi.tammipeli.domain.Pelaava;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Pelinappula;
import jalotammi.tammipeli.domain.Ruutu;
import java.util.ArrayList;

public class Tietokonepelaaja implements Pelaava {
    private final String nimi = "MR. PC";
    private ArrayList<Pelinappula> nappulat;
    private ArrayList<Pelinappula> syovat;
    private Pelinappula syonyt;
    private Vari vari;
    private int nappuloitasyoty;
    private boolean vuorossa;
    private Pelilauta pl;
    private Ruutuarpoja ruutuarpoja;

    public Tietokonepelaaja(Pelilauta pl) {
        this.nappulat = new ArrayList<Pelinappula>();
        this.syovat = new ArrayList<Pelinappula>();
        this.nappuloitasyoty = 0;
        this.pl = pl;
        this.vuorossa = false;
        
    }
     
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

    public boolean alustaVuoro() {
        listaaNappulat();
        listaaSyovat();
        vuorossa = true;
        return pystyykoJatkamaanPelia();
    }
    public void pelaa(){
        Ruutu lahto;
        Ruutu vali;
        Ruutu maali;
        if(!syovat.isEmpty()){
            lahto = ruutuarpoja.arvoLahtoRuutu(syovat);
            ArrayList<Ruutu> ruudut = ruutuarpoja.arvoMaaliSyontiRuutu(lahto);
            maali = ruudut.get(0);
            vali = ruudut.get(1);
        }else{
            lahto = ruutuarpoja.arvoLahtoRuutu(nappulat);
            maali = ruutuarpoja.arvoMaaliLiikkumisRuutu(lahto);
            vali = maali;
        }liikutaNappulaa(lahto, vali, maali);
    }

    public boolean isVuorossa() {
        return vuorossa;
    }

    public void liikutaNappulaa(Ruutu lahto, Ruutu vali, Ruutu maali) {
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
        nappuloitasyoty++;
        if(maali.getNappula().pystyykoSyomaan()){
            syonyt = maali.getNappula();
        }else{
            vuorossa = false;
            setSyonyt(null);
        }
    }

    public void setVari(Vari vari) {
        this.vari = vari;
    }

    public void setVuorossa(boolean vuorossa) {
        this.vuorossa = vuorossa;
    }     

    public ArrayList<Pelinappula> getSyovat() {
        return syovat;
    }

    public Pelinappula getSyonyt() {
       return syonyt;
    }
    public int getNappuloitasyoty(){
        return nappuloitasyoty;
    }
     @Override
    public String toString() {
        if(vari == null){
            return nimi;
        }
        return nimi + " (" + vari.toString()+ ")";
    }

    public Pelilauta getPl() {
        return pl;
    }

    private void setSyonyt(Pelinappula nappula) {
        syonyt = nappula;
    }

    public int getSiirrot() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
