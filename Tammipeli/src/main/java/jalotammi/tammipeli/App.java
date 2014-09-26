package jalotammi.tammipeli;

import jalotammi.tammipeli.domain.Pelaaja;
import jalotammi.tammipeli.domain.Pelilauta;
import jalotammi.tammipeli.kayttoliittyma.Kayttoliittyma;
import javax.swing.SwingUtilities;


public class App 
{
    public static void main( String[] args )
    {
        Pelilauta pl = new Pelilauta();
        pl.lisaaPeliNappulat();
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(pl);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
