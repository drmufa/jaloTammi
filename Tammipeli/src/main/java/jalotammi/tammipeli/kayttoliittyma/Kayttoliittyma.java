package jalotammi.tammipeli.kayttoliittyma;



import static jalotammi.tammipeli.Vari.PUNAINEN;
import jalotammi.tammipeli.domain.Lukupari;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelaava;
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
     /**
     * Luokka luo Pelin pääikkunan johon hahmottuu pelilaudan
     * ja nappuloiden ilmentymät
     */ 
public class Kayttoliittyma implements Runnable {

    private Pelilauta pelilauta;
    private JFrame frame;
    private JPanel tammilauta;
    private Tammiruutu[][] tammiruudukko = new Tammiruutu[8][8];
    private static final String aakkoset = "ABCDEFGH";
    private Tammiruutu valittu;
    private Tammiruutu valittu2;
    private Pelaava pelaaja1;
    private Pelaava pelaaja2;
    private JLabel teksti = new JLabel("Let's get ready to rumble");
    private JLabel ohjeita = new JLabel("?");
    private Tekstigeneraattori tg;
    private final Voittopopup voittopopup = new Voittopopup(); 
    
    /**
     * Konstruktorissa annetaan kyttoliittymään liittyvä pelilauta
     * 
     */ 
    
    public Kayttoliittyma(Pelilauta pelilauta) {
        this.pelilauta = pelilauta;
        this.tg = new Tekstigeneraattori(teksti, this);
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
    /**
     * Metodi luo peliin tarviitavat komponentit kayttoliitymaan
     * 
     */ 

    private void luoKomponentit(Container container) {
        lisaaToiminnot(container);
        lisaaRuudukko(container);
    }
    
    /**
     * Metodi luo peliin aloitus näppeimen, josta pääsee lisäämään
     * peliin osallistuvat pelaajat. Metodi luo myös näppeimen josta pääse
     * tarkastelemaan huipputuloksia
     */ 

    private void lisaaToiminnot(Container container) {
        JToolBar toiminnot = new JToolBar();
        JToolBar ohjeistus = new JToolBar();
        //toiminnot.setFloatable(false);
        JButton aloita = new JButton("Aloita");
        toiminnot.add(aloita);
        Pelinaloituskuuntelija pk = new Pelinaloituskuuntelija(this);
        aloita.addActionListener(pk);
        JButton huipputulokset = new JButton("Huipputulokset");
        toiminnot.add(huipputulokset);
        HiscoreLista hi = new HiscoreLista();
        huipputulokset.addActionListener(hi);
        toiminnot.addSeparator();
        toiminnot.add(teksti);
        JButton what = new JButton("What?");
        Ohjenapinkuuntelija on = new Ohjenapinkuuntelija(this, ohjeita);
        ohjeistus.add(what);
        what.addActionListener(on);
        ohjeistus.addSeparator();
        ohjeistus.add(ohjeita);
        container.add(toiminnot, BorderLayout.NORTH);
        container.add(ohjeistus, BorderLayout.SOUTH);
    }
    /**
     * Metodi lisaa kayttöliittymään alueen johon luodaan ruudut 
     * taytaTammiruudukko metodissa
     * 
     * @param container run() metodissa luotu frame olio
     * 
     * @see taytaTammiruudukko
     */ 
    
    private void lisaaRuudukko(Container container){
        tammilauta = new JPanel(new GridLayout(0, 9));
        tammilauta.setBorder(new LineBorder(Color.BLACK));
        container.add(tammilauta, BorderLayout.CENTER);
        taytaTammiruudukko();
        lisaaRuudut();
        tammilauta.setVisible(true);
    }
    /**
     * Metodi lisaa ruudukon tammiruutuja (extends JButton) joihin jokaiseen 
     * liitetään pelilaudata yksi ruutu ja tapahtuma kuuntelija. 
     * Joka toinen ruutu on musta ja jokatoinen valkoinen.
     */
    
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
    /**
     * Metodi paivittaa kayttoliittymän näyttäen nappuloiden paikat ja 
     * valitut ruudut.
     * 
     */ 
    public void paivitaPeli(){
        for (Tammiruutu[] tammiruutus : tammiruudukko) {
            for (Tammiruutu tammiruutu : tammiruutus) {
                tammiruutu.naytaNappula();
                tammiruutu.maalaaRuutu();
                if(valittu != null){
                    valittu.setBackground(Color.cyan);
                }
                if(valittu2 != null){
                    valittu2.setBackground(Color.cyan);
                }
            }
        }
        tg.muutaTekstia();
    }
    
    public void setValittu(Tammiruutu valittu) {
        this.valittu = valittu;
    }

    public Tammiruutu getValittu() {
        return valittu;
    }

    public Tammiruutu getValittu2() {
        return valittu2;
    }
  

    public void setValittu2(Tammiruutu valittu2) {
        this.valittu2 = valittu2;
    }

    public void setPelaaja1(Pelaava pelaaja1) {
        this.pelaaja1 = pelaaja1;
    }

    public void setPelaaja2(Pelaava pelaaja2) {
        this.pelaaja2 = pelaaja2;
    }

    public Pelaava getPelaaja1() {
        return pelaaja1;
    }

    public Pelaava getPelaaja2() {
        return pelaaja2;
    }

    public Tekstigeneraattori getTg() {
        return tg;
    }
    public void tyhjennaOhjeet(){
        ohjeita.setText("?");
    }

    public Voittopopup getVoittopopup() {
        return voittopopup;
    }
    
}