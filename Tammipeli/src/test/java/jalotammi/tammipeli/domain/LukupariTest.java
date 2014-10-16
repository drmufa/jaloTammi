/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jalotammi.tammipeli.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jajnousi
 */
public class LukupariTest {
    Lukupari pari1;
    Lukupari pari2;
    
    public LukupariTest() {
    }
    
    
    @Before
    public void setUp() {
        pari1 = new Lukupari(1,2);
        pari2 = new Lukupari(2,4);
    }
    @Test
    public void testaaGettereita(){
        assertEquals(1, pari1.getX());
        assertEquals(4, pari2.getY());
    }
    @Test
    public void testaaToStringia(){
        assertEquals(pari1.toString(), "C2");
        assertEquals(pari2.toString(), "E3");
    }

}
