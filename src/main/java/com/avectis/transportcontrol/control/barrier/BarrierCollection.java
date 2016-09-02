package com.avectis.transportcontrol.control.barrier;

import java.util.Collection;

/**
 * Created by vitaly on 01.09.2016.
 */
public class BarrierCollection implements BarrierCollector {

    private Collection<Barrier> barrierCollection;

    public void setBarrierCollection(Collection<Barrier> barrierCollection){
        this.barrierCollection = barrierCollection;
    }
    @Override
    public Collection<Barrier> getBarrierCollection() {
        return this.barrierCollection;
    }
    public Barrier GetBarrier(String name){
        for (Barrier barrier: barrierCollection) {
            if(name.equals(barrier.name)){
                return barrier;
            }
        }
        return null;
    }
}
