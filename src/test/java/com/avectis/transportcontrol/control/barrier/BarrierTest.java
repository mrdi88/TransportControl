package com.avectis.transportcontrol.control.barrier;

import org.junit.Test;

/**
 * Created by vitaly on 30.08.2016.
 */
public class BarrierTest {
    @Test
    public void open() throws Exception {
        BarrierAdapterCOM AB1 = new BarrierAdapterCOM("COM1");
        BarrierAdapterCOM AB2 = new BarrierAdapterCOM("COM2");
        Barrier B1 = new Barrier("Barrier #1", AB1);
        Barrier B2 = new Barrier("Barrier #2", AB2);
        System.out.println("!!!!!!!!!!!!!!!!!!Barrier 1!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Open::::::::::::::::::::::::::::::::::::::::::::::");
        B1.Open();
        System.out.println("Close:::::::::::::::::::::::::::::::::::::::::::::");
        B1.Close();
        System.out.println("GetState::::::::::::::::::::::::::::::::::::::::::");
        B1.GetState();

        System.out.println("!!!!!!!!!!!!!!!!!!Barrier 1!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("Open::::::::::::::::::::::::::::::::::::::::::::::");
        B2.Open();
        System.out.println("Close:::::::::::::::::::::::::::::::::::::::::::::");
        B2.Close();
        System.out.println("GetState::::::::::::::::::::::::::::::::::::::::::");
        B2.GetState();
    }

    @Test
    public void close() throws Exception {

    }

    @Test
    public void getState() throws Exception {

    }

}