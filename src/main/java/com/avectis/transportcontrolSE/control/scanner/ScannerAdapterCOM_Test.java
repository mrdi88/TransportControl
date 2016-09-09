package com.avectis.transportcontrolSE.control.scanner;

import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;


/**
 * Created by vitaly on 02.09.2016.
 */
public class ScannerAdapterCOM_Test implements ScannerAdapter_Test {

    private SerialPort serialPort; //Имя COM-порта
    private int baudRate;
    private int dataBits;
    private int stopBits;
    private int parity;

    public ScannerAdapterCOM_Test(){ }
    public ScannerAdapterCOM_Test(String portName){
        try{
            this.serialPort = new SerialPort(portName);
            this.serialPort.openPort();
            this.serialPort.setParams(this.baudRate, this.dataBits, this.stopBits, this.parity);
            this.serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
            //this.serialPort.addEventListener(new EventCOM(), this.serialPort.MASK_RXCHAR);
        }
        catch (SerialPortException e){
            e.printStackTrace();
        }
    }
    
    public class EventCOM implements SerialPortEventListener{

        @Override
        public void serialEvent(SerialPortEvent spe) {
            System.out.println("OK");
        }
//    
    }
        @Override
        public String GetData(){
            return "123";
        }
        
    private void Send(){
        System.out.println("Write to " + this.serialPort.getPortName());
    }
    private void Receive(){
        System.out.println("Read  of " + this.serialPort.getPortName());
    }

    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public void setDataBits(int dataBits) {
        this.dataBits = dataBits;
    }

    public int getDataBits() {
        return dataBits;
    }

    public void setStopBits(int stopBits) {
        this.stopBits = stopBits;
    }

    public int getStopBits() {
        return stopBits;
    }

    public void setParity(int parity) {
        this.parity = parity;
    }

    public int getParity() {
        return parity;
    }
}
