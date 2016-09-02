/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.facade;

import com.avectis.transportcontrol.DAO.CarDAO;
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import com.avectis.transportcontrol.view.CarView;
import com.avectis.transportcontrol.view.CargoView;
import com.avectis.transportcontrol.view.DriverView;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dima
 */
public class CarFacade {

    public CarFacade() {
    }
    
    private CarDAO carDAO;

    public void setCarDAO(CarDAO carDAO) {
        this.carDAO = carDAO;
    } 
    
    public Long add(CarView car){
        return carDAO.addCar(carFromView(car));
    }
    public void update(CarView car){
        carDAO.update(carFromView(car));
    }
    public CarView get(Long id){
        return new CarView(carDAO.getCar(id));
    }
    public List<CarView> getList(Date from, Date to){
        List<Car> cars=carDAO.getCars(from, to);
        List<CarView> carsView= new ArrayList<>();
        for (Car car:cars){
            carsView.add(new CarView(car));
        }
        return carsView;
    }
    public void delete(CarView car){
        carDAO.deleteCar(carFromView(car));
    }
    public void deleteList(List<CarView> cars){
        for (CarView car:cars){
            carDAO.deleteCar(carFromView(car));
        }
    }
    
    public Car carFromView(CarView carv){
        Car car = new Car();
        car.setCargo(cargoFromView(carv.getCargo()));
        car.setCreateDate(carv.getCreateDate());
        car.setDestination(carv.getDestination());
        car.setDriver(driverFromView(carv.getDriver()));
        car.setFirstNumber(carv.getFirstNumber());
        car.setId(carv.getId());
        car.setLeaveDate(carv.getLeaveDate());
        car.setSecondNumber(carv.getSecondNumber());
        return car;
    }
    
    public Driver driverFromView(DriverView driverv){
        if (driverv==null) return null;
        Driver driver = new Driver();
        driver.setId(driverv.getId());
        driver.setMobileNumber(driverv.getMobileNumber());
        driver.setName(driverv.getName());
        driver.setOrganization(driverv.getOrganization());
        return driver;
    }
    public Cargo cargoFromView(CargoView cargov){
        if (cargov==null) return null;
        Cargo cargo = new Cargo();
        cargo.setDischargeDate(cargov.getDischargeDate());
        cargo.setDischargingPlace(cargov.getLoadingPlace());
        cargo.setId(cargov.getId());
        cargo.setLoadingDate(cargov.getLoadingDate());
        cargo.setLoadingPlace(cargov.getLoadingPlace());
        cargo.setQuality(cargov.getQuality());
        cargo.setWeightIn(cargov.getWeightIn());
        cargo.setWeightOut(cargov.getWeightOut());
        return cargo;
    }
}

