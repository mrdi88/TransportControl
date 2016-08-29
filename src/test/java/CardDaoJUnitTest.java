/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.DAO.CarDAO;
import com.avectis.transportcontrol.DAO.CardDAO;
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
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
public class CardDaoJUnitTest {
    
    public CardDaoJUnitTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("CardDao test begins");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("CardDao test ends");
    }
    
    @Test
    public void card() {
        try{
            //===Car
            Driver driver=CarDAO.createDriver("Dunkan Maklaud", "+375295023336", "OAO Shilda");
            Cargo cargo=CarDAO.createCargo();
            cargo.setWeightIn(3000);
            cargo.setQuality(3);
            CarDAO.Update(cargo);
            Car car=CarDAO.createCar(cargo, driver, "4755-KK7", "7777-KT7", null);
            System.out.println("cr  car: " + car);
            assertNotNull(car);
            //greate card
            Card card=CardDAO.createCard();
            card.setCar(car);
            card.setAccessLevel(1);
            card.setCardNumber(4566665);
            card.setCreateDate(new Date());
            card.setState(0);
            CardDAO.Update(card);
            Card card_temp=CardDAO.getCard(card.getCardId());
            System.out.println("cr  card: " + card);
            System.out.println("get card: " + card_temp);
            assertEquals(card,card_temp);
            //add car
            //===Card
            Driver driver2=CarDAO.createDriver("Dunkan Maklaud2", "+375295023336", "OAO Shilda");
            Cargo cargo2=CarDAO.createCargo();
            cargo.setWeightIn(3002);
            cargo.setQuality(2);
            CarDAO.Update(cargo2);
            Car car2=CarDAO.createCar(cargo2, driver2, "4755-KK7", "7777-KT7", null);
            System.out.println("cr  car2: " + car2);
            assertNotNull(car2);
            //greate card2
            Card card2=CardDAO.createCard();
            card2.setCar(car2);
            card2.setAccessLevel(2);
            card2.setCardNumber(4566665);
            card2.setCreateDate(new Date());
            card2.setState(0);
            CardDAO.Update(card2);
            //try list
            List<Card> cards=CardDAO.getCards();
            System.out.println("Cards List: "+cards);
            //delete car
            CardDAO.deleteCard(card);
            CardDAO.deleteCard(card2);
            card=CardDAO.getCard(card.getCardId());
            assertEquals(card,null);
            card2=CardDAO.getCard(card2.getCardId());
            assertEquals(card2,null);
            //delete cars
            CarDAO.deleteCar(car);
            CarDAO.deleteCar(car2);
        }
        catch(Exception e){
            System.out.println("CarDao ex: " + e);
            e.printStackTrace();
            fail();
        }
    }    
}
