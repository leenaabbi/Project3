/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nandini
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Game.
     */
//    @Test
//    public void testMain() {
//        System.out.println("Testing starts here");
//        String[] args = null;
//        Game.main(args);
        // TODO review the generated test code and remove the default call to fail.
       
    

    /**
     * Test of checkValue method, of class Game.
     */
    @Test
    public void testCheckValueGood() {
        System.out.println("checkValueGood");
        String result_2 = "1";
        boolean expResult = true;
        boolean result = Game.checkValue(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
     @Test
    public void testCheckValueBad() {
        System.out.println("checkValueBad");
        String result_2 = "67";
        boolean expResult = false;
        boolean result = Game.checkValue(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testCheckValueBoundary() {
        System.out.println("checkValueBoundary");
        String result_2 = "0";
        boolean expResult = true;
        boolean result = Game.checkValue(result_2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

}
