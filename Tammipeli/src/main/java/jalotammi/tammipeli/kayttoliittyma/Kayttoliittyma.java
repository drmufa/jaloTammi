package jalotammi.tammipeli.kayttoliittyma;



import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JPanel tammilauta;
    private JButton[][] tammiruudukko = new JButton[8][8]; 

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("TAMMI");
        frame.setPreferredSize(new Dimension(600, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(new JButton("Let's get ready to rumble"), BorderLayout.NORTH);
    }

    public JFrame getFrame() {
        return frame;
    }
}