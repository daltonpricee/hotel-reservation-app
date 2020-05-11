import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
*Tests for PresidentalSuite.java.
*/
public class PresidentalSuiteTest {
 
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Tests getName(). **/
   @Test public void getNameTest() {
    
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 1, 2);
      String name = ps.getName();
      Assert.assertEquals("Dalton Price", name);
      
   }
   
   /** Test setName(). **/
   @Test public void setNameTest() {
   
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 1, 2);
      String name = "Dalton Price";
      ps.setName(name);
      Assert.assertEquals(ps.getName(), name);
   
   }
   
   /** Test getNumOfNights(). **/
   @Test public void getNumOfNightsTest() {
    
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      int numOfNights = ps.getNumOfNights();
      Assert.assertEquals(5, numOfNights);
      
   }
   
   /** Test setNumOfNights(). **/
   @Test public void setNumOfNightsTest() {
   
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      int numOfNights = 5;
      ps.setNumOfNights(numOfNights);
      Assert.assertEquals(ps.getNumOfNights(), 5);
   
   }
   
   /** Test getNumOfPeople(). **/
   @Test public void getNumOfPeopleTest() {
    
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      int numOfPeople = ps.getNumOfPeople();
      Assert.assertEquals(2, numOfPeople);
      
   }
   
   /** Test setName(). **/
   @Test public void setNumOfPeopleTest() {
   
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      int numOfPeople = 2;
      ps.setNumOfPeople(numOfPeople);
      Assert.assertEquals(ps.getNumOfPeople(), numOfPeople);
   
   }
   
   /** Test calculateTotal(). **/
   @Test public void calculateTotalTest() {
      
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 1, 2);
      int numOfNights = 1;
      ps.setNumOfNights(numOfNights);
      ps.calculateTotal(numOfNights);
      Assert.assertEquals(ps.calculateTotal(numOfNights), 200.00, 0.0001);
    
   }
    
   /** Test addSR(). **/
   @Test public void addSRTest() {
       
      Map<String, PresidentalSuite>psrMap = new LinkedHashMap<String, PresidentalSuite>();
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      String name = ps.getName();
      ps.getNumOfNights();
      ps.getNumOfPeople();
      ps.addPS(name);
      Map<String, PresidentalSuite> m = ps.getList();
      Assert.assertEquals(ps.getList(), m);
       
   }
     
   /** Test cancelSR(). **/
   @Test public void cancelSRTest() {
         
      Map<String, PresidentalSuite> psMap = new LinkedHashMap<String, PresidentalSuite>();
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      String name = ps.getName();
      ps.cancelPS(name);
      Map<String, PresidentalSuite> m = ps.getList();
      Assert.assertEquals(ps.getList(), m);
       
   }
      
   /** Test SummaryInfo(). **/
   @Test public void summaryInfoTest() {
         
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      String info = ps.summaryInfo();
      Assert.assertEquals(info, ps.summaryInfo());
         
   }
       
    /** Test toString(). **/
   @Test public void toStringTest() {
         
      PresidentalSuite ps = new PresidentalSuite("Dalton Price", 5, 2);
      String info = ps.toString();
      Assert.assertEquals(info, ps.toString());
         
   }
       
}