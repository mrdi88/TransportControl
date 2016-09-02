package com.avectis.transportcontrol.control.scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vitaly on 02.09.2016.
 */
public class ScannerTest {
    @Test
    public void Scanner() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ScannerCollection scannerCollection =(ScannerCollection) context.getBean("scannerCollection");

        System.out.println("!!!!!!!!!!!!!!!!!!Scanner  1!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("GetState::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(scannerCollection.GetScanner("scanner1").GetData());

        System.out.println("!!!!!!!!!!!!!!!!!!Scanner 2!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("GetState::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(scannerCollection.GetScanner("scanner2").GetData());
    }

}