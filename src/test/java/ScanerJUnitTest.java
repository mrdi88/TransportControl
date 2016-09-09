/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.avectis.transportcontrolSE.control.scanner.CardScanner;
import com.avectis.transportcontrolSE.control.scanner.CardScannerAdapterCOM;
import com.avectis.transportcontrolSE.control.scanner.TestListener;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Ivan
 */
public class ScanerJUnitTest {
    
    public ScanerJUnitTest() {
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

    

    @Test
    public void mainTest() throws InterruptedException {
        
        System.out.println("Test started");
        
        CardScannerAdapterCOM AdapterTest = new CardScannerAdapterCOM("com6", 9600, 8, 1, 0);
        CardScanner ScannerTest = new CardScanner("Scanner 1", AdapterTest);
        
        TestListener L1 = new TestListener();
        TestListener L2 = new TestListener();
        TestListener L3 = new TestListener();

        ScannerTest.addListener(L1);
        ScannerTest.addListener(L2);
        ScannerTest.addListener(L3);
        
        Thread.sleep(100000);
        
        AdapterTest.disconnect();
        System.out.println("Test finished");
        
    }
    
    
}
