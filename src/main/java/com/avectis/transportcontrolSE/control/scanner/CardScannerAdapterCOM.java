package com.avectis.transportcontrolSE.control.scanner;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
/**
 *
 * @author Ivan
 */
public class CardScannerAdapterCOM implements CardScannerAdapter {
    
    public SerialPort serialPort; //COM порт сканера карт
    
    public int baudRate;
    public int bitCount;
    public int stopBits;
    public int parity;
    
    public CardScannerAdapterCOM(String portName){
        this.serialPort = new SerialPort(portName);
        this.baudRate = 9600; 
        this.bitCount = 8;
        this.stopBits = 1;
        this.parity = 0;
         
        try{
            this.serialPort.setParams(this.baudRate, this.bitCount, this.stopBits, this.parity);
            this.serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            serialPort.openPort();
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }    
    }
    public CardScannerAdapterCOM(String portName, int baudRate, int dataBits, int stopBits, int parity){
        this.serialPort = new SerialPort(portName);
        
        this.baudRate = baudRate; 
        this.bitCount = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
         
        try{
            this.serialPort.openPort();
            if(this.serialPort.isOpened()){
                System.out.println("COM port opened");
            }
            this.serialPort.setParams(this.baudRate, this.bitCount, this.stopBits, this.parity);
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }    
    }
        
    @Override
    public void connect(){
        try{
            if(!(serialPort.isOpened())){
                serialPort.openPort();
            }
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
    @Override
    public void disconnect(){
        try{
            if(serialPort.isOpened()){
            serialPort.closePort();
            }
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
    @Override
    public void reconnect(){
        disconnect();
        connect();
    }
    @Override
    public void isConnected(){
        this.serialPort.isOpened();
    }
    @Override
    public void addPortListener(SerialPortEventListener listener){       
        try{
            this.serialPort.addEventListener(listener, this.serialPort.MASK_RXCHAR);
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
    @Override
    public void removePortListener(){       
        try{
            this.serialPort.removeEventListener();
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
    @Override
    public String getReceivedData() {
        try{
            return this.serialPort.readString();
        }
        catch (SerialPortException e){
            e.printStackTrace();
            return "";
        }
    }
    @Override
    public void ClearBuffers(){
        try{
            this.serialPort.purgePort(serialPort.PURGE_RXCLEAR + serialPort.PURGE_TXCLEAR);
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
    
}


