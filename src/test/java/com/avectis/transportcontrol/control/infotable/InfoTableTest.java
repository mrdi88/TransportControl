package com.avectis.transportcontrol.control.infotable;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vitaly on 02.09.2016.
 */
public class InfoTableTest {
    @Test
    public void InfoTable() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        InfoTableCollection infoTableCollection =(InfoTableCollection) context.getBean("infoTableCollection");

        System.out.println("!!!!!!!!!!!!!!!!!!InfoTable 1!!!!!!!!!!!!!!!!!!!!!!!");
        infoTableCollection.GetScoreboard("InfoTable1").SendData(new String[]{"info", "table1"});
        System.out.println(infoTableCollection.GetScoreboard("InfoTable1").getDateLastUpdate());

        System.out.println("!!!!!!!!!!!!!!!!!!InfoTable 2!!!!!!!!!!!!!!!!!!!!!!!");
        infoTableCollection.GetScoreboard("InfoTable2").SendData(new String[]{"info", "table2"});
        System.out.println(infoTableCollection.GetScoreboard("InfoTable2").getDateLastUpdate());
    }

}