package com.avectis.transportcontrol.control.infotable;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Created by vitaly on 02.09.2016.
 */
public class InfoTable {
    public String name;
    public LocalDateTime dateLastUpdate;
    private final int lineCount;
    private InfoTableAdapter infoTableAdapter;

    public InfoTable(String name, int lineCount, InfoTableAdapter infoTableAdapter) {
        this.name = name;
        this.lineCount = lineCount;
        this.infoTableAdapter = infoTableAdapter;
    }

    public LocalDateTime getDateLastUpdate() {
        return dateLastUpdate;
    }

    private void setDateLastUpdate(LocalDateTime dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }

    public void SendData(String [] data){
        this.infoTableAdapter.SendData(data, lineCount);
        LocalDateTime time = LocalDateTime.now(ZoneId.of("Europe/Minsk"));
        setDateLastUpdate(time);
    }
}
