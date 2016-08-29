/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.avectis.transportcontrol.DAO.TransportQueueDAO;
import com.avectis.transportcontrol.entity.TransportQueue;
import com.avectis.transportcontrol.entity.TransportQueueElement;
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
public class TransportQueueDaoJUnitTest {
    
    public TransportQueueDaoJUnitTest() {
    }
    @BeforeClass
    public static void setUpClass() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        System.out.println("TransportQueueDao test begins");
    }
    @AfterClass
    public static void tearDownClass() {
        System.out.println("TransportQueueDao test ends");
    }
    
    @Test
    public void transportQueue() {
        try{
            //===Queue
            TransportQueue tq1=TransportQueueDAO.createQueue("R01");
            TransportQueue tq2=TransportQueueDAO.createQueue("R02");
            TransportQueue tq3=TransportQueueDAO.createQueue("R03");
            TransportQueue tq4=TransportQueueDAO.createQueue("R04");
            //===Elements
            TransportQueueElement elem1=TransportQueueDAO.createQueueElement();
            TransportQueueElement elem2=TransportQueueDAO.createQueueElement();
            TransportQueueElement elem3=TransportQueueDAO.createQueueElement();
            //===
            tq1.getqElements().add(elem1);
            tq1.getqElements().add(elem2);
            tq1.getqElements().add(elem3);
            TransportQueueDAO.Update(tq1);
            //===
            TransportQueueElement elem4=new TransportQueueElement();
            tq2.getqElements().add(elem4);
            tq2.getqElements().add(new TransportQueueElement());
            TransportQueueDAO.Update(tq2);
            //=get
            List<TransportQueue> list=TransportQueueDAO.getQueueList();
            for(TransportQueue tq:list){
                System.out.println("queue name: " + tq.getName());
            }
            System.out.println("list size: " + list.size());
            System.out.println("TransportQueue list: " + list);
            assertEquals(list.size(), 4);
            //delete
            for(TransportQueue tq:list){
                System.out.println("queue name: " + tq.getName());
                TransportQueueDAO.deleteQueue(tq);
            }
            assertEquals(TransportQueueDAO.getQueueList().size(), 0);
        }
        catch(Exception e){
            System.out.println("TransportQueue ex: " + e);
            e.printStackTrace();
            fail();
        }
    }    
}
