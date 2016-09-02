package com.avectis.transportcontrol.control.traffic_light;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vitaly on 02.09.2016.
 */
public class TrafficLightTest {
    @Test
    public void TrafficLight() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TrafficLightCollection trafficLightCollection =(TrafficLightCollection) context.getBean("trafficLightCollection");

        System.out.println("!!!!!!!!!!!!!!!!!!TrafficLight 1!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("TurnON::::::::::::::::::::::::::::::::::::::::::::::");
        trafficLightCollection.GetTrafficLight("traffic_light1").TurnOn();
        System.out.println("TurnOff:::::::::::::::::::::::::::::::::::::::::::::");
        trafficLightCollection.GetTrafficLight("traffic_light1").TurnOff();
        System.out.println("GetState::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(trafficLightCollection.GetTrafficLight("traffic_light1").GetState());

        System.out.println("!!!!!!!!!!!!!!!!!!TrafficLight 2!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("TurnON::::::::::::::::::::::::::::::::::::::::::::::");
        trafficLightCollection.GetTrafficLight("traffic_light2").TurnOn();
        System.out.println("TurnOff:::::::::::::::::::::::::::::::::::::::::::::");
        trafficLightCollection.GetTrafficLight("traffic_light2").TurnOff();
        System.out.println("GetState::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(trafficLightCollection.GetTrafficLight("traffic_light2").GetState());
    }

}