package com.avectis.transportcontrol.control.traffic_light;

import java.util.Collection;

/**
 * Created by vitaly on 01.09.2016.
 */
public class TrafficLightCollection implements TrafficLightCollector {

    private Collection<TrafficLight> trafficLightCollection;

    public void setTrafficLightsCollection(Collection<TrafficLight> trafficLightCollection){
        this.trafficLightCollection = trafficLightCollection;
    }
    @Override
    public Collection<TrafficLight> getTrafficLightCollection() {
        return this.trafficLightCollection;
    }

    public TrafficLight GetTrafficLight(String name){
        for (TrafficLight trafficLight: trafficLightCollection) {
            if(name.equals(trafficLight.name)){
                return trafficLight;
            }
        }
        return null;
    }

 
}
