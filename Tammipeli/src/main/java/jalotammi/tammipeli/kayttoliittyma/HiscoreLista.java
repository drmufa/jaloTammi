
package jalotammi.tammipeli.kayttoliittyma;

import jalotammi.tammipeli.domain.Huipputuloskasittelija;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *Luokka näyttää Hiscorelistan popup ikkunassa. Ikkunan saa näkyviin
 *aloitus ikkunasta tai sen jälkeen kun on pelannut huipputuloksen.
 * 
 */
public class HiscoreLista implements ActionListener{
    private JFrame frame;
    
    public void run() {
        frame = new JFrame("TAMMI");
        frame.setPreferredSize(new Dimension(200, 200));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(5, 1);
        container.setLayout(layout);
        Huipputuloskasittelija hk = new Huipputuloskasittelija();
        try {
            for (String string : hk.lueTiedosto()) {
                container.add(new JLabel(string));                         
            }
        } catch (FileNotFoundException ex) {
        }
    }

    public void actionPerformed(ActionEvent ae) {
        this.run();
    }
}
