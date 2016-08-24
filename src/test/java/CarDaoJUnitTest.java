/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.DAO.CarDAO;
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author DPoplauski
 */
public class CarDaoJUnitTest {
    
    public CarDaoJUnitTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("CarDao test begins");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("CarDao test ends");
    }

    @Test
    public void driver() {
        try{
            //===Driver
            //greate Driver
            Driver driver = CarDAO.createDriver("Frank", "+375296488772", "OOO Gerimi1");
            System.out.println("created driver: " + driver);
            assertNotNull(driver);
            //get and check
            Driver driver_temp = CarDAO.getDriver(driver.getDriverId());
            assertEquals(driver,driver_temp);
            //delete drivers and check
            CarDAO.deleteDriver(driver);
            driver = CarDAO.getDriver(driver.getDriverId());
            assertEquals(driver,null);
        }
        catch(Exception e){
            System.out.println("CarDao ex: " + e);
            fail();
        }
    }
    @Test
    public void cargo() {
        try{
            //create Cargo
            Cargo cargo=CarDAO.createCargo(4, 4000, 0, null, null, null, null);
            System.out.println("created cargo: " + cargo);
            assertNotNull(cargo);
            //get and check
            Cargo cargo_temp=CarDAO.getCargo(cargo.getCargoId());
            assertEquals(cargo,cargo_temp);
            //delete cargo and check
            CarDAO.deleteCargo(cargo);
            cargo=CarDAO.getCargo(cargo.getCargoId());
            assertEquals(cargo,null);
        }
        catch(Exception e){
            System.out.println("CarDao ex: " + e);
            fail();
        }
    }
    @Test
    public void car() {
        try{
            //===Car
            Driver driver=CarDAO.createDriver("Dunkan Maklaud", "+375295023336", "OAO Shilda");
            Cargo cargo=CarDAO.createCargo();
            cargo.setWeightIn(3000);
            cargo.setQuality(3);
            CarDAO.Update(cargo);
            Car car=CarDAO.createCar(cargo, driver, "4755-KK7", "7777-KT7", null);
            System.out.println("created car: " + car);
            assertNotNull(car);
            //get car and check
            Car car_temp=CarDAO.getCar(car.getCarId());
            assertEquals(car,car_temp);
            //try list
            Driver driver2=CarDAO.createDriver("Dunkan Maklaud", "+375295023336", "OAO Shilda");
            Cargo cargo2=CarDAO.createCargo();
            cargo2.setWeightIn(3000);
            cargo2.setQuality(3);
            CarDAO.Update(cargo2);
            Car car2=CarDAO.createCar(cargo2, driver2, "4755-KK7", "7777-KT7", null);
            Date dt=new Date();
            dt.setHours(2);
            car2.setCreateDate(dt);
            CarDAO.Update(car2);
            List<Car> cars=CarDAO.getCars(new Date(), null);
            
            System.out.println("Cars List: "+cars);
            //delete car
            CarDAO.deleteCar(car);
            CarDAO.deleteCar(car2);
            car=CarDAO.getCar(car.getCarId());
            assertEquals(car,null);
        }
        catch(Exception e){
            System.out.println("CarDao ex: " + e);
            e.printStackTrace();
            fail();
        }
    }    
}
