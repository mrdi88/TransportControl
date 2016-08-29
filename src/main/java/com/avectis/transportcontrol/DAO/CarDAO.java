/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DPoplauski
 */
public interface CarDAO {
    public void Update(Object object);
    public Driver createDriver();
    public Driver createDriver(String name, String mobileNumber, String organization);
    public Driver getDriver(Long id);
    public void deleteDriver(Driver driver);
    public Cargo createCargo(int quality, int weightIn, int weightOut, String dischargingPlace, Date dischargeDate, String loadingPlace, Date loadingDate);
    public Cargo createCargo();
    public Cargo getCargo(Long id);
    public void deleteCargo(Cargo cargo);
    public Car createCar(Cargo cargo, Driver driver, String firstNumber, String secondNumber, String destination);
    public Car createCar();
    public Car getCar(Long id);
    public List<Car> getCars(Date startDate, Date endDate);
    public void deleteCar(Car car);
}
