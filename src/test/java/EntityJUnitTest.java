/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.entity.Car;
import com.avectis.transportcontrol.entity.Card;
import com.avectis.transportcontrol.entity.Cargo;
import com.avectis.transportcontrol.entity.Driver;
import com.avectis.transportcontrol.entity.TransportQueue;
import com.avectis.transportcontrol.entity.TransportQueueElement;
import java.util.Date;
import java.util.TimeZone;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author DPoplauski
 */
public class EntityJUnitTest {
    private static SessionFactory sessionFactory;
    // A SessionFactory is set up once for an application!
    
    public EntityJUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("entities test begins");
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                        .configure() // configures settings from hibernate.cfg.xml
                        .build();
        try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
                // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
                // so destroy it manually.
                System.out.println("ex: " + e);
                StandardServiceRegistryBuilder.destroy( registry );
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("entities test ends");
        if ( sessionFactory != null ) {
			sessionFactory.close();
	}
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testDriver(){
        try {
                // create a couple of drivers...
                System.out.println("driver test");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
                Driver dr1=new Driver( "Dima", "+375292051312","avectis");
                Long id=(Long)session.save(dr1);
		session.getTransaction().commit();
		session.close();
                System.out.println("saved in db: "+dr1);
                // get driver
                session = sessionFactory.openSession();
		session.beginTransaction();
		Driver dr2=(Driver)session.get( Driver.class, id );
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+dr2);
                // is equal
                assertEquals(dr1, dr2);
                // delete object
                session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(dr2);
		session.getTransaction().commit();
		session.close();
                System.out.println("object deleted");
                //check that it not exists
                session = sessionFactory.openSession();
		session.beginTransaction();
		dr1=(Driver)session.get(Driver.class,id);
		session.getTransaction().commit();
		session.close();
                assertEquals(dr1, null);
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
    @Test
    public void testCargo(){
        try {
                // create a couple of drivers...
                System.out.println("cargo test");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
                Cargo cargo1=new Cargo();
                cargo1.setWeightIn(5000);
                cargo1.setQuality(5);
                Date dt= new Date();
                cargo1.setLoadingDate(dt);
                Long id=(Long)session.save(cargo1);
		session.getTransaction().commit();
		session.close();
                System.out.println("saved in db: "+cargo1);
                // get cargo
                session = sessionFactory.openSession();
		session.beginTransaction();
		Cargo cargo2=(Cargo)session.get( Cargo.class, id );
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+cargo2);
                // is equal
                assertEquals(cargo1, cargo2);
                // delete object
                session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(cargo2);
		session.getTransaction().commit();
		session.close();
                System.out.println("object deleted");
                //check that it not exists
                session = sessionFactory.openSession();
		session.beginTransaction();
		cargo2=(Cargo)session.get(Cargo.class,id);
		session.getTransaction().commit();
		session.close();
                assertEquals(cargo2, null);
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
    @Test
    public void testCar(){
        try {
                // create a couple of drivers...
                System.out.println("car test");
		Session session = sessionFactory.openSession();
		session.beginTransaction();
                Car car1=new Car();
                //driver
                Driver dr= new Driver( "Dima", "+375292051312","avectis"); 
                //cargo
                Cargo cargo=new Cargo();
                cargo.setWeightIn(5000);
                cargo.setQuality(5);
                Date dt= new Date();
                cargo.setLoadingDate(dt);
                //set prop to car
                car1.setDriver(dr);
                car1.setCargo(cargo);
                car1.setFirstNumber("4700-EM1");
                car1.setSecondNumber("4800-EM1");
                //save
                Long id=(Long)session.save(car1);
		session.getTransaction().commit();
		session.close();
                System.out.println("saved in db: "+car1);
                // get car
                session = sessionFactory.openSession();
		session.beginTransaction();
		Car car2=(Car)session.get( Car.class, id );
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+car2);
                // is equal
                assertEquals(car1, car2);
                //delete car
		session = sessionFactory.openSession();
		session.beginTransaction();
                session.delete(car1);
                session.getTransaction().commit();
		session.close();
                //check if deleted
                session = sessionFactory.openSession();
		session.beginTransaction();
		car1=(Car)session.get(Car.class,id);
		session.getTransaction().commit();
		session.close();
                assertEquals(car1, null);
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
    @Test
    public void testCard(){
        try {
                System.out.println("card test");
                Car car=new Car();
                //driver
                Driver driver= new Driver( "Dima", "+375292051312","avectis"); 
                //cargo
                Cargo cargo=new Cargo();
                cargo.setWeightIn(5000);
                cargo.setQuality(5);
                cargo.setLoadingDate(new Date());
                //set prop to car
                car.setDriver(driver);
                car.setCargo(cargo);
                car.setFirstNumber("4700-EM1");
                car.setSecondNumber("4800-EM1");
                //new card 
                Card card=new Card(car,23423L,0,1);
                //save
                Session session = sessionFactory.openSession();
		session.beginTransaction();
                Long car_id=(Long)session.save(car);
                Long id=(Long)session.save(card);
                session.getTransaction().commit();
		session.close();
                System.out.println("saved in db: "+card);
                //get 
                session = sessionFactory.openSession();
		session.beginTransaction();
		Card card2=(Card)session.get( Card.class, id );
                card2.getCar().getDriver().setName("Nikolay");
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+card2);
                // is equal
                //assertEquals(card, card2);
                //delete 
		session = sessionFactory.openSession();
		session.beginTransaction();
                session.delete(card2);
                session.getTransaction().commit();
		session.close();
                //check if deleted
                session = sessionFactory.openSession();
		session.beginTransaction();
		card=(Card)session.get(Card.class,id);
		session.getTransaction().commit();
		session.close();
                assertEquals(card, null);
                //get car
                session = sessionFactory.openSession();
		session.beginTransaction();
		car=(Car)session.get( Car.class, car_id );
                assertNotEquals(car, null);
		session.getTransaction().commit();
		session.close();
		System.out.println("red from db :"+card2);
                //delete car
		session = sessionFactory.openSession();
		session.beginTransaction();
                session.delete(car);
                session.getTransaction().commit();
		session.close();
                //check if deleted
                session = sessionFactory.openSession();
		session.beginTransaction();
		car=(Car)session.get(Car.class,car_id);
		session.getTransaction().commit();
		session.close();
                assertEquals(car, null);
                System.out.println("End");       
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
    @Test
    public void QueueTest(){
        try{
            System.out.println("Queue test");
            //greate
            Car car=new Car();
            Driver driver= new Driver( "Dima", "+375292051312","avectis"); 
            Cargo cargo=new Cargo();
            cargo.setWeightIn(5000);
            cargo.setQuality(5);
            cargo.setLoadingDate(new Date());
            car.setDriver(driver);
            car.setCargo(cargo);
            car.setFirstNumber("4700-EM1");
            car.setSecondNumber("4800-EM1");
            Card card=new Card(car,23423L,0,1);
            TransportQueueElement qe=new TransportQueueElement();
            qe.setCard(card);
            TransportQueue tq=new TransportQueue();
            tq.setName("r01");
            tq.getqElements().add(qe);
            //save
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Long car_id=(Long)session.save(car);
            Long card_id=(Long)session.save(card);
            Long tq_id=(Long)session.save(tq);
            session.getTransaction().commit();
            session.close();
            //get and add
            TransportQueueElement qe2=new TransportQueueElement();
            TransportQueueElement qe3=new TransportQueueElement();
            session = sessionFactory.openSession();
            session.beginTransaction();
            tq=session.get(TransportQueue.class,tq_id);
            tq.getqElements().add(qe2);
            tq.getqElements().add(qe3);
            session.getTransaction().commit();
            session.close();
            // read
            session = sessionFactory.openSession();
            session.beginTransaction();
            tq=session.get(TransportQueue.class,tq_id);
            System.out.println("red: " + tq);
            session.getTransaction().commit();
            session.close();
            assertEquals(tq.getqElements().size(),3);
            //delete tg and car,card
            session = sessionFactory.openSession();
            session.beginTransaction();
            tq=session.get(TransportQueue.class,tq_id);
            card=session.get(Card.class,card_id);
            car=session.get(Car.class,car_id);
            session.delete(tq);
            session.delete(card);
            session.delete(car);
            session.getTransaction().commit();
            session.close();
            //check if deleted tq and car,card
            session = sessionFactory.openSession();
            session.beginTransaction();
            tq=session.get(TransportQueue.class,tq_id);
            card=session.get(Card.class,card_id);
            car=session.get(Car.class,car_id);
            session.getTransaction().commit();
            session.close();
            assertEquals(tq,null);
            assertEquals(card,null);
            assertEquals(car,null);
            
        }
        catch(Exception e) {
            System.out.println("ex: " + e);
            fail();
        }
        System.out.println("End");
    }
}
