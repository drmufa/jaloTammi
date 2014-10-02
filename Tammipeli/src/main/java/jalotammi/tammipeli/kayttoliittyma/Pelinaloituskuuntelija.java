/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.kayttoliittyma;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *Luokka laukaisee aloitus popup ikkunan
 * 
 */
public class Pelinaloituskuuntelija implements ActionListener {
    private JFrame frame;
    private Kayttoliittyma kl;

    public Pelinaloituskuuntelija (Kayttoliittyma kl) {
        this.kl = kl;
    }
    
 
    public void luopopup(){
        frame = new JFrame("Pelaajat");
        frame.setPreferredSize(new Dimension(500, 100));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
     /**
     * Metodi tarjoaa kentätä joihin pelaajat voivat kirjoittaa nimensä
     * ja liittyä peliin
     * 
     * @param container luopopup metodissa luotu frame olio
     */ 
    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);

        JLabel nimiTeksti = new JLabel("Pelaaja 1: ");
        JLabel nimiTeksti2 = new JLabel("Pelaaja 2: ");
        JTextField nimiKentta = new JTextField();
        JTextField nimiKentta2 = new JTextField();

        JButton lisaaNappi = new JButton("Aloita peli");
        Pelaajanlisayskuuntelija pl = new Pelaajanlisayskuuntelija(nimiKentta, nimiKentta2, frame, kl);
        lisaaNappi.addActionListener(pl);
        
        container.add(nimiTeksti);
        container.add(nimiKentta);
        container.add(nimiTeksti2);
        container.add(nimiKentta2);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }

    @Override
     public void actionPerformed(ActionEvent e) {
        luopopup();
    }

    public JFrame getFrame() {
        return frame;
    }
     
}

