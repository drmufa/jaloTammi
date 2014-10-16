/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
  * Luokka lukee ja kirjoittaa huipputulokset.txt tiedostoa.
  */

public class Huipputuloskasittelija {


    public Huipputuloskasittelija() {
    }
    /**
     * metodi tarkistaa mille huipputulos sijalle pelaaja pääsee
     * 
     * @param pelaajan siirtojen määrä
     * @return pelaajan sijoitus huipputuloksissa
     */
    public int tarkistaHuipputulos(int siirrot) throws FileNotFoundException{
        int sijoitus = 6;
        for(String string: this.lueTiedosto()){  
            if (siirrot < Integer.parseInt(string.substring(3, 6))){
                sijoitus --;
            } 
        }
        return sijoitus;
    }
    /**
     * metodi lukee huipputulostiedoston ja tekee siitä ArrayList:n
     * 
     * @return ArrayList jossa tiedoston rivit listana.
     */
    public  ArrayList<String> lueTiedosto() throws FileNotFoundException{
        ArrayList<String> lista = new ArrayList<String>();
        File huipputulokset = new File("src/Huipputulokset.txt");
        Scanner lukija = null;
        try {
            lukija = new Scanner(huipputulokset);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return null;
        }
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            lista.add(rivi);
            //System.out.println(rivi);
        }
        lukija.close();
        return lista;
    }
    /**
     * Metodi kirjoittaa huipputuloksen listaan, jos tarvetta.
     * 
     * @param Pelaajan siirrot
     * @param Pelaajan haluama nimimerkki
     */
    public void tallenaHuipputulos(Integer siirrot, String voittajanTagi) throws IOException{
        int j = this.tarkistaHuipputulos(siirrot);
        ArrayList<String> tulokset = this.lueTiedosto();
        File huipputulokset = new File("src/Huipputulokset.txt");
        FileWriter kirjoittaja = new FileWriter(huipputulokset);
        String teksti = "";
        for (String rivi : tulokset) {
            int i = Integer.parseInt(rivi.substring(0, 1));
            if(i == j){
                teksti = teksti + i + ". " + 
                        teeEtuNollat(siirrot)+ " " +voittajanTagi +  "\n";
            }else{
                teksti = teksti + rivi + "\n";
            }
        }
        kirjoittaja.write(teksti);
        kirjoittaja.close();
        this.lueTiedosto();
    }
    private String teeEtuNollat(Integer siirrot){
        if(siirrot<10){
            return "00"+ siirrot;
        } if (siirrot <100){
            return "0" + siirrot;
        }else{
            return siirrot.toString();
        }
    }
    /**
     * Metodi palauttaa huipputulos listan alkuperäiseen muotoon jos tarvetta
     */
    public void palutaHuipputulokset() throws IOException{
        File huipputulokset = new File("src/Huipputulokset.txt");
        FileWriter kirjoittaja = new FileWriter(huipputulokset);
        String teksti = "1. 005 Urho Kekkonen\n2. 020 Mr. PC\n3. 050 - \n"
                + "4. 100 - \n5. 200 -";
        kirjoittaja.write(teksti);
        kirjoittaja.close();
        this.lueTiedosto();
    }
    
}
