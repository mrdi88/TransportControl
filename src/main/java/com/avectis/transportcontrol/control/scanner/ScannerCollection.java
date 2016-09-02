package com.avectis.transportcontrol.control.scanner;

import java.util.Collection;

/**
 * Created by vitaly on 02.09.2016.
 */
public class ScannerCollection implements ScannerCollector{
    private Collection<Scanner> scannerCollection;

    public void setScannerCollection(Collection<Scanner> scannerCollection){
        this.scannerCollection = scannerCollection;
    }
    @Override
    public Collection<Scanner> getScannerCollection() {
        return null;
    }

    public Scanner GetScanner(String name){
        for (Scanner scanner: scannerCollection) {
            if(name.equals(scanner.name)){
                return scanner;
            }
        }
        return null;
    }
}
