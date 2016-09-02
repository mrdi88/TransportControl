package com.avectis.transportcontrol.control.infotable;

import java.util.Collection;

/**
 * Created by vitaly on 02.09.2016.
 */
public class InfoTableCollection implements InfoTableCollector {

    private Collection<InfoTable> infoTableCollection;

    public void setInfoTableCollection(Collection<InfoTable> infoTableCollection){
        this.infoTableCollection = infoTableCollection;
    }

    @Override
    public Collection<InfoTable> getBarrierCollection() {
        return this.infoTableCollection;
    }

    public InfoTable GetScoreboard(String name){
        for (InfoTable infotable: infoTableCollection) {
            if(name.equals(infotable.name)){
                return infotable;
            }
        }
        return null;
    }
}
