
import com.avectis.transportcontrol.facade.CarFacade;
import com.avectis.transportcontrol.facade.CardFacade;
import com.avectis.transportcontrol.facade.QueueFacade;
import com.avectis.transportcontrol.view.CarView;
import com.avectis.transportcontrol.view.CargoView;
import com.avectis.transportcontrol.view.DriverView;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.Assert.*;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"/tcsDataBase.xml", "/tcsFacade.xml"})
//@TransactionConfiguration(transactionManager = "transactionManager")
public class FacadeTest extends AbstractJUnit4SpringContextTests {//AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CarFacade carFacade;
    @Autowired
    private CardFacade cardFacade;
    @Autowired
    private QueueFacade queueFacade;

    @Test
    //@Rollback(false)
    public void carFacadeTest() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        CarView car= new CarView();
        DriverView driver = new DriverView("Dima","+375292051312","avectis");
        CargoView cargo = new CargoView();
        car.setCreateDate(new Date());
        car.setFirstNumber("4700-EM1");
        car.setSecondNumber("4700-EM2");
        car.setCargo(cargo);
        car.setDriver(driver);
        car.setId(carFacade.add(car));
        System.out.println("===");
        CarView saved_car=carFacade.get(car.getId());
        car.getDriver().setId(saved_car.getDriver().getId());
        car.getCargo().setId(saved_car.getCargo().getId());
        System.out.println("add : "+car);
        System.out.println("get : "+saved_car);
        //get car
        assertEquals(car,saved_car);
        //create car list
        car.setId(0);
        car.getCargo().setId(0);
        car.getDriver().setId(0);
        carFacade.add(car);
        carFacade.add(car);
        carFacade.add(car);
        //get list
        List<CarView> cvList=carFacade.getList(null, null);
        assertEquals(cvList.size(),4);
        System.out.println("car list ===");
        for (CarView cv:cvList){
            System.out.println(cv);
        }
        //update 
        saved_car.getDriver().setName("Sasha");
        carFacade.update(saved_car);
        car = carFacade.get(saved_car.getId());
        assertEquals(car.getDriver().getName(),saved_car.getDriver().getName());
        //delete
    }
}
