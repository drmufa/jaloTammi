package jalotammi.tammipeli.kayttoliittyma;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import static javax.swing.text.html.HTML.Attribute.COLS;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private JPanel tammilauta;
    private JButton[][] tammiruudukko = new JButton[8][8];
    private static final String aakkoset = "ABCDEFGH";

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
        lisaaToiminnot(container);
        lisaaRuudukko(container);
    }

    private void lisaaToiminnot(Container container) {
        JToolBar toiminnot = new JToolBar();
        //toiminnot.setFloatable(false);
        JButton aloita = new JButton("Aloita");
        toiminnot.add(aloita);
        Pelinaloituskuuntelija pk = new Pelinaloituskuuntelija();
        aloita.addActionListener(pk);
        toiminnot.add(new JButton("Huipputulokset"));
        toiminnot.addSeparator();
        toiminnot.add(new JLabel("Let's get ready to rumble"));        
        container.add(toiminnot, BorderLayout.NORTH);
    }
    private void lisaaRuudukko(Container container){
        tammilauta = new JPanel(new GridLayout(0, 9));
        tammilauta.setBorder(new LineBorder(Color.BLACK));
        container.add(tammilauta, BorderLayout.CENTER);
        taytaTammiruudukko();
        lisaaRuudut();
    }
    private void taytaTammiruudukko(){
        for (int i = 0; i < tammiruudukko.length; i++) {
            for (int j = 0; j < tammiruudukko.length; j++) {
                JButton ruutu = new JButton();
                if ((j % 2 == 1 && i % 2 == 1)
                        || (j % 2 == 0 && i % 2 == 0)) {
                    ruutu.setBackground(Color.LIGHT_GRAY);
                } else {
                    ruutu.setBackground(Color.BLACK);
                }
                tammiruudukko[j][i] = ruutu;
            }
        }      
    }
    private void lisaaRuudut(){
        tammilauta.add(new JLabel(""));
         for (int i = 0; i < 8; i++) {
            tammilauta.add(
                    new JLabel(aakkoset.substring(i, i + 1),
                    SwingConstants.CENTER));
        }
         for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (j) {
                    case 0:
                        tammilauta.add(new JLabel("" + (i + 1),
                                SwingConstants.CENTER));
                    default:
                        tammilauta.add(tammiruudukko[i][j]);
                }
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}