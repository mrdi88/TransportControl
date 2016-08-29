/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avectis.transportcontrol.DAO;

import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import com.avectis.transportcontrol.util.HibernateUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author DPoplauski
 */
public class CarDAO {
     /**
     * unpade entity using Hibernate
     * 
     * @param object Object - witch entity to update
     */
    public static void Update(Object object){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(object);
            session.getTransaction().commit();
        }
    }
    /**
     * create new not initialied Driver entity using Hibernate
     * 
     * @return created driver entity
     */
    public static Driver createDriver(){
        Driver driver=new Driver();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(driver);
            driver.setDriverId(id);
            session.getTransaction().commit();
        }
        return driver;
    }
    /**
     * create new Driver entity using Hibernate
     * 
     * @param name String - driver's name 
     * @param mobileNumber String - driver's mobileNumber
     * @param organization String - driver's organization
     * @return created driver entity
     */
    public static Driver createDriver(String name, String mobileNumber, String organization){
        Driver driver=new Driver(name,mobileNumber,organization);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(driver);
            driver.setDriverId(id);
            session.getTransaction().commit();
        }
        return driver;
    }
    /**
     * get Driver object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return Driver object
     */
    public static Driver getDriver(Long id){
        Driver driver;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            driver = (Driver)session.get( Driver.class, id );
            session.getTransaction().commit();
        }
        return driver;
    }
    /**
     * delete Driver object from DB using Hibernate
     * 
     * @param driver Driver - Driver object to delete
     */
    public static void deleteDriver(Driver driver){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(driver);
	session.getTransaction().commit();
	session.close();
    }
    /**
     * create new Cargo entity using Hibernate
     * 
     * @param quality int - Cargo quality - int
     * @param weightIn int - weight of cargo before discharging or loading
     * @param weightOut int - weight of cargo after discharging or loading
     * @param dischargingPlace String - place of discharging
     * @param dischargeDate Date - place of discharging
     * @param loadingPlace String - place of loading
     * @param loadingDate Date - place of loading
     * @return created Driver entity
     */
    public static Cargo createCargo(int quality, int weightIn, int weightOut, String dischargingPlace, Date dischargeDate, String loadingPlace, Date loadingDate){
        Cargo cargo=new Cargo(quality, weightIn, weightOut, dischargingPlace, dischargeDate, loadingPlace, loadingDate);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(cargo);
            cargo.setCargoId(id);
            session.getTransaction().commit();
        }
        return cargo;
    }
    /**
     * create new not initialized Cargo entity using Hibernate
     * 
     * @return created Driver entity
     */
    public static Cargo createCargo(){
        Cargo cargo=new Cargo();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(cargo);
            cargo.setCargoId(id);
            session.getTransaction().commit();
        }
        return cargo;
    }
    /**
     * get Cargo object from DB using Hibernate
     * 
     * @param id Long - identifier of entity object
     * @return Cargo object
     */
    public static Cargo getCargo(Long id){
        Cargo cargo;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            cargo = (Cargo)session.get( Cargo.class, id );
            session.getTransaction().commit();
        }
        return cargo;
    }
    /**
     * delete Cargo object from DB using Hibernate
     * 
     * @param cargo Cargo - cargo object to delete
     */
    public static void deleteCargo(Cargo cargo){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(cargo);
            session.getTransaction().commit();
        }
    }
     /**
     * create new Car entity using Hibernate
     * 
     * @param cargo Cargo - Cargo entity
     * @param driver Driver - Driver entity
     * @param destination String - current destination of car
     * @param firstNumber String - number of car
     * @param secondNumber String - number of trailer
     * @return created Car entity
     */
    public static Car createCar(Cargo cargo, Driver driver, String firstNumber, String secondNumber, String destination){
        Car car=new Car(cargo, driver, destination, firstNumber, secondNumber);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(car);
            car.setCarId(id);
            session.getTransaction().commit();
        }
        return car;
    }
     /**
     * create new not initialized Car entity using Hibernate
     * 
     * @return created Car entity
     */
    public static Car createCar(){
        Car car=new Car();
        Date dt=new Date();
        dt.setTime(dt.getTime()-dt.getTime()%1000);
        car.setCreateDate(dt);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Long id=(Long)session.save(car);
            car.setCarId(id);
            session.getTransaction().commit();
        }
        return car;
    }
    /**
     * get Car object from DB using Hibernate
     * 
     * @return Car object
     */
    public static Car getCar(Long id){
        Car car;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            car = (Car)session.get( Car.class, id );
            session.getTransaction().commit();
        }
        return car;
    }
    /**
     * get Cars for period from DB using Hibernate
     * 
     * @param startDate Date - from date
     * @param endDate Date - to date
     * @return List of Car objects
     */
    public static List<Car> getCars(Date startDate, Date endDate){
        List<Car> cars = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Criteria criteria = session.createCriteria(Car.class);
            if(startDate != null) {
                criteria.add(Restrictions.ge("createDate", startDate));
            }
            if(endDate != null) {
                criteria.add(Restrictions.le("createDate", endDate));
            }
            criteria.addOrder(Order.asc("createDate"));
            cars=criteria.list();
            session.getTransaction().commit();
        }
        return cars;
    }
    /**
     * delete Car object from DB using Hibernate
     * 
     * @param car Car - car object to delete
     */
    public static void deleteCar(Car car){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(car);
            session.getTransaction().commit();
        }
    }
}
