
package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Huipputuloskasittelija;
import jalotammi.tammipeli.domain.Pelaava;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *Luokka kutsuu Huipputuloskasittelijaa kirjaamaan huipputuloksen 
 *hiscore-listaan, kun pelaaja on antanut nimimerkkinsä. Luokka kutsuu myös
 *hiscorelistaa ilmestymään tämän jälkeen.
 *
 * @see Huipputuloskasittelija
 * @see HiscoreLista
 * 
 */
public class HiScoreKuuntelija implements ActionListener{
    private Huipputuloskasittelija hk;
    private Pelaava pelaaja;
    private JTextField nimiKentta;
    private JFrame frame;

    public HiScoreKuuntelija(Huipputuloskasittelija hk, Pelaava pelaaja, 
            JTextField nimiKentta, JFrame frame) {
        this.hk = hk;
        this.pelaaja = pelaaja;
        this.nimiKentta = nimiKentta;
        this.frame = frame;
    }

   
    
    public void actionPerformed(ActionEvent ae) {
        String pelaajanTagi = this.nimiKentta.getText();
        try {
            hk.tallenaHuipputulos(pelaaja.getSiirrot(), pelaajanTagi);
        } catch (IOException ex) {
            
        }
        HiscoreLista hi = new HiscoreLista();
        hi.run();
        frame.setVisible(false);
    }
    
}
