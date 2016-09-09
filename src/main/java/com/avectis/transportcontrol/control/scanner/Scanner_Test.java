package com.avectis.transportcontrol.control.scanner;

/**
 * Created by vitaly on 02.09.2016.
 */
public class Scanner_Test {
    public String name;
    private ScannerAdapter_Test scannerAdapter;
    public Scanner_Test(String scannerName, ScannerAdapter_Test scannerAdapter){
        this.name = scannerName;
        this.scannerAdapter = scannerAdapter;
    }
    public String GetData(){
        return this.scannerAdapter.GetData();
    }

    public Scanner_Test() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScannerAdapter(ScannerAdapter_Test scannerAdapter) {
        this.scannerAdapter = scannerAdapter;
    }
    
}
