package jalotammi.tammipeli;

import jalotammi.tammipeli.domain.Huipputuloskasittelija;
import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.kayttoliittyma.HiScorePopup;
import jalotammi.tammipeli.kayttoliittyma.Kayttoliittyma;
import java.io.IOException;
import javax.swing.SwingUtilities;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        //Huipputuloskasittelija hp = new Huipputuloskasittelija();
        //hp.palutaHuipputulokset();
        //hp.lueTiedosto();
        //hp.tallenaHuipputulos(20, "Joumän");
        
        
        Pelilauta pl = new Pelilauta();
        pl.lisaaPeliNappulat();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pl);
        SwingUtilities.invokeLater(kayttoliittyma);
        
       
    }
}
