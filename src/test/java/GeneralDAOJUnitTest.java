/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.DAO.DAO;
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import com.avectis.transportcontrol.entity.Queue;
import com.avectis.transportcontrol.entity.QueueElement;
import java.util.List;
import java.util.TimeZone;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author DPoplauski
 */
public class GeneralDAOJUnitTest {
    
    public GeneralDAOJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("GeneralDAO test begin");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("GeneralDAO test end");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void test1() {
        try{
            //create driver
            Driver driver=DAO.carDAO.createDriver();
            driver.setName("Dima");
            driver.setMobileNumber("+375292031312");
            driver.setOrganization("ODO Avectis");
            System.out.println("created driver : "+driver);
            DAO.carDAO.Update(driver);
            //create cargo
            Cargo cargo=DAO.carDAO.createCargo();
            System.out.println("created cargo  : "+cargo);
            //create car
            Car car = DAO.carDAO.createCar(cargo, driver, "4700-EM1", "4700-EM2", null);
            //assert
            System.out.println("created car    : "+car);
            assertEquals(car,DAO.carDAO.getCar(car.getId()));
            //create card
            Card card=DAO.cardDAO.createCard();
            card.setCar(car);
            card.setCardNumber(5889888);
            card.setState(0);
            DAO.cardDAO.Update(card);
            System.out.println("created card   : "+card);
            //assert
            assertEquals(card,DAO.cardDAO.getCard(card.getId()));
            //create QueueElement
            QueueElement tqe=DAO.queueDAO.createQueueElement(card);
            //assert
            assertEquals(tqe,DAO.queueDAO.getQueueElement(tqe.getId()));
            //create Queue
            Queue tq=DAO.queueDAO.createQueue("R01");
            tq.getqElements().add(tqe);
            DAO.queueDAO.Update(tq);
            //assert
            assertEquals(tq,DAO.queueDAO.getQueue(tq.getId()));
            //
            List<QueueElement> tqList=DAO.queueDAO.getQueueByName("R01").getqElements();
            String driverName=tqList.get(0).getCard().getCar().getDriver().getName();
            System.out.println("driver name :" + driverName);
            assertEquals(driverName,driver.getName());
            //delete
            DAO.queueDAO.deleteQueue(tq);
            DAO.cardDAO.deleteCard(card);
            DAO.carDAO.deleteCar(car);
        }
        catch(Exception e){
            System.out.println("GeneralDAO ex: " + e);
            fail();
        }
    }
}
