package jalotammi.tammipeli.kayttoliittyma;



import static jalotammi.tammipeli.Vari.PUNAINEN;
import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.domain.Ruutu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.ImageProducer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

public class Kayttoliittyma implements Runnable {

    private Pelilauta pelilauta;
    private JFrame frame;
    private JPanel tammilauta;
    private Tammiruutu[][] tammiruudukko = new Tammiruutu[8][8];
    private static final String aakkoset = "ABCDEFGH";
    private Tammiruutu valittu;
    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;
    

    public Kayttoliittyma(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

    @Override
    public void run() {
        frame = new JFrame("TAMMI");
        frame.setPreferredSize(new Dimension(600, 670));

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
        Pelinaloituskuuntelija pk = new Pelinaloituskuuntelija(this);
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
                Tammiruutu ruutu = new Tammiruutu(pelilauta.getPelialusta()[j][i]);
                if ((j % 2 == 1 && i % 2 == 1)
                        || (j % 2 == 0 && i % 2 == 0)) {
                    ruutu.setBackground(Color.LIGHT_GRAY);
                    Ruudunvalintakuuntelija rv = 
                            new Ruudunvalintakuuntelija(new Lukupari(j,i), pelilauta, ruutu, this);
                    ruutu.addActionListener(rv);
                } else {
                    ruutu.setBackground(Color.BLACK);
                    Ruudunvalintakuuntelija rv = 
                            new Ruudunvalintakuuntelija(new Lukupari(j,i), pelilauta, ruutu, this);
                    ruutu.addActionListener(rv);
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

    public Pelilauta getPelilauta() {
        return pelilauta;
    }
    
    public void paivitaPeli(){
        for (Tammiruutu[] tammiruutus : tammiruudukko) {
            for (Tammiruutu tammiruutu : tammiruutus) {
                tammiruutu.naytaNappula();
            }
        }
    }
    public void setValittu(Tammiruutu valittu) {
        this.valittu = valittu;
    }

    public Tammiruutu getValittu() {
        return valittu;
    }

    public void setPelaaja1(Pelaaja pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    public void setPelaaja2(Pelaaja pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    public Pelaaja getPelaaja1() {
        return pelaaja1;
    }

    public Pelaaja getPelaaja2() {
        return pelaaja2;
    }
    
}