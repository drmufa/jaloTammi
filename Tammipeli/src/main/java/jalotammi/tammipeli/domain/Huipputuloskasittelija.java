/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Huipputuloskasittelija {
    
    private FileWriter kirjoittaja;
    private Scanner lukija;
   //URL textURL;
    private File huipputulokset;

    public Huipputuloskasittelija() throws IOException {
        //this.textURL = getClass().getResource("Huipputulokset.txt");
        //this.huipputulokset = new File(textURL.toString());
        this.huipputulokset = new File("/domain/Huipputulokset.txt");
        this.kirjoittaja = new FileWriter(huipputulokset);
        this.lukija = new Scanner(huipputulokset);
    }
    public int tarkistaHuipputulos(int siirrot){
        int sijoitus = 6;
        while(lukija.hasNextLine()){
            System.out.println(Integer.parseInt(lukija.nextLine().substring(3, 6)));  
            if (siirrot < Integer.parseInt(lukija.nextLine().substring(3, 6))){
                sijoitus --;
            } 
        }
        return sijoitus;
    }

    public void lueTiedosto(){
     while(lukija.hasNextLine()){
         System.out.println(lukija.nextLine());
        }
    }
    
    public void tallenaHuipputulos(Pelaaja voittaja, String voittajanTagi){
        
    }
  
}
