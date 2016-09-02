package com.avectis.transportcontrol.control.barrier;

/**
 * Created by vitaly on 24.08.2016.
 */
public class Barrier {

    public String   name;
    private boolean  state;
    private BarrierAdapter barrierAdapter;

    public Barrier(String barrierName, BarrierAdapter barrierAdapter){
        this.name = barrierName;
        this.state = false;
        this.barrierAdapter = barrierAdapter;
    }

    public void Open(){
        this.barrierAdapter.Open();
    }
    public void Close(){
        this.barrierAdapter.Close();
    }
    public void GetState(){
        this.barrierAdapter.GetState();
    }












}
