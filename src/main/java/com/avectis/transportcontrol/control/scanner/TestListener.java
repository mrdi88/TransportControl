package com.avectis.transportcontrol.control.scanner;

/**
 *
 * @author Ivan
 */
public class TestListener implements CardScannerListener {
        @Override 
        public void onCardLogined(String CardNumberHEX,String CardNumberDEC){
            System.out.println("=> Card Info [" + CardNumberHEX + "] " + CardNumberDEC + " <=");
        }
        @Override 
        public void onCardRemoved(){
            System.out.println("=======> Card Removed <=======");
        }
}
