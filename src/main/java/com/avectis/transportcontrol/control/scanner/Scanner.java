package com.avectis.transportcontrol.control.scanner;

/**
 * Created by vitaly on 02.09.2016.
 */
public class Scanner {
    public String name;
    private ScannerAdapter scannerAdapter;
    public Scanner(String scannerName, ScannerAdapter scannerAdapter){
        this.name = scannerName;
        this.scannerAdapter = scannerAdapter;
    }
    public String GetData(){
        System.out.println("Scanner name:="+this.name + " cmd:=GetData" );
        return this.scannerAdapter.GetData();
    }
}