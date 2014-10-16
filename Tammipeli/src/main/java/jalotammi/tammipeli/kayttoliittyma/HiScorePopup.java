
package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Huipputuloskasittelija;
import jalotammi.tammipeli.domain.Pelaava;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *Luokka luo popup ikkunan, joka ilmestyy kun voitat tarpeeksi
 *pinellä siirtomäärällä. Ikkunaan syötetään pelaajan haluama nimimerkki.
 * 
 */
public class HiScorePopup {
    private JFrame frame;
    private Huipputuloskasittelija hk;
    private Pelaava pelaaja;

    public HiScorePopup(Huipputuloskasittelija hk, Pelaava pelaaja) {
        this.hk = hk;
        this.pelaaja = pelaaja;
    }
    
    
     public void luopopup(){
        frame = new JFrame("HiScore");
        frame.setPreferredSize(new Dimension(500, 100));

        luoKomponentit(frame.getContentPane(), pelaaja);

        frame.pack();
        frame.setVisible(true);
    }
      private void luoKomponentit(Container container, Pelaava pelaaja) {
        GridLayout layout = new GridLayout(3, 2);
        container.setLayout(layout);

        JLabel hiscore = new JLabel("SAIT HUIPPUTULOKSEN!!");
        JLabel tyhjateksti = new JLabel(pelaaja.toString());
        JLabel nimiTeksti = new JLabel("Anna nimi: ");
        JTextField nimiKentta = new JTextField();

        JButton lisaaNappi = new JButton("OK");
        HiScoreKuuntelija pl = new HiScoreKuuntelija(hk, pelaaja, nimiKentta, frame);
        lisaaNappi.addActionListener(pl);
        
        container.add(hiscore);
        container.add(nimiTeksti);
        container.add(tyhjateksti);
        container.add(nimiKentta);
        container.add(new JLabel(""));
        container.add(lisaaNappi);
    }

    public JFrame getFrame() {
        return frame;
    }
      
}
