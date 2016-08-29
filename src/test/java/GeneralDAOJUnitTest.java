/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.DAO.CarDAO;
import com.avectis.transportcontrol.DAO.CardDAO;
import com.avectis.transportcontrol.DAO.TransportQueueDAO;
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import com.avectis.transportcontrol.entity.TransportQueue;
import com.avectis.transportcontrol.entity.TransportQueueElement;
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
            Driver driver=CarDAO.createDriver();
            driver.setName("Dima");
            driver.setMobileNumber("+375292031312");
            driver.setOrganization("ODO Avectis");
            System.out.println("created driver : "+driver);
            CarDAO.Update(driver);
            //create cargo
            Cargo cargo=CarDAO.createCargo();
            System.out.println("created cargo  : "+cargo);
            //create car
            Car car = CarDAO.createCar(cargo, driver, "4700-EM1", "4700-EM2", null);
            //assert
            System.out.println("created car    : "+car);
            assertEquals(car,CarDAO.getCar(car.getCarId()));
            //create card
            Card card=CardDAO.createCard();
            card.setCar(car);
            card.setCardNumber(5889888);
            card.setState(0);
            CardDAO.Update(card);
            System.out.println("created card   : "+card);
            //assert
            assertEquals(card,CardDAO.getCard(card.getCardId()));
            //create QueueElement
            TransportQueueElement tqe=TransportQueueDAO.createQueueElement(card);
            //assert
            assertEquals(tqe,TransportQueueDAO.getQueueElement(tqe.getqElementId()));
            //create TransportQueue
            TransportQueue tq=TransportQueueDAO.createQueue("R01");
            tq.getqElements().add(tqe);
            TransportQueueDAO.Update(tq);
            //assert
            assertEquals(tq,TransportQueueDAO.getQueue(tq.getQueueId()));
            //
            List<TransportQueueElement> tqList=TransportQueueDAO.getQueueByName("R01").getqElements();
            String driverName=tqList.get(0).getCard().getCar().getDriver().getName();
            System.out.println("driver name :" + driverName);
            assertEquals(driverName,driver.getName());
            //delete
            TransportQueueDAO.deleteQueue(tq);
            CardDAO.deleteCard(card);
            CarDAO.deleteCar(car);
        }
        catch(Exception e){
            System.out.println("GeneralDAO ex: " + e);
            fail();
        }
    }
}
