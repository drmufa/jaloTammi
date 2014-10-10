/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelaava;
import static jalotammi.tammipeli.kayttoliittyma.Tammiruutu.createImageIcon;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Voittopopup {
    private JFrame frame;
    private static ImageIcon voittopokaali = 
            createImageIcon("voittoPokaali.png", "VOIT");
    
    protected static ImageIcon createImageIcon(String path,
                                           String description) {
    java.net.URL imgURL = Pelaaja.class.getResource(path);
        if (imgURL != null) {
        return new ImageIcon(imgURL, description);
        } else {
        System.err.println("Couldn't find file: " + path);
        return null;
        }
    }
    
    public void luopopup(Pelaava pelaaja){
        frame = new JFrame("Pelaajat");
        frame.setPreferredSize(new Dimension(500, 300));

        luoKomponentit(frame.getContentPane(), pelaaja);

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container, Pelaava pelaaja) {
        container.add(new JLabel("ONNITTELUT! "+ pelaaja.toString()+ " OLET VOITTANUT" ), 
                BorderLayout.NORTH);
        JLabel pokaali = new JLabel("");
        pokaali.setIcon(voittopokaali);
        container.add(pokaali, BorderLayout.CENTER);
    }    

}
