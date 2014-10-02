

package jalotammi.tammipeli.domain;
/**
  * Luokka käytetään kaksi ulotteisen paikan hahmottamiseen pelilaudalla
  */ 
public class Lukupari {
    public int x, y;
    private static final String aakkoset = "ABCDEFGH";
    
    public Lukupari(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        int i = x + 1;
        int j = y;
        String kirjain = aakkoset.substring(j, j + 1);
        return  kirjain + i;
    }
    
  }
