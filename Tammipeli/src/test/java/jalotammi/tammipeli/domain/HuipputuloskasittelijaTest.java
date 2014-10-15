/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class HuipputuloskasittelijaTest {
    
    public HuipputuloskasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test
    public void TestaaTarkistaHuippuTulos() throws IOException{
        Huipputuloskasittelija hp = new Huipputuloskasittelija();
        assertEquals(hp.tarkistaHuipputulos(2), 1);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
