import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.*;

public class StandardRoomTest {
 
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Tests getName(). **/
   @Test public void getNameTest() {
    
      StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
      String name = sr.getName();
      Assert.assertEquals("Dalton Price", name);
      
   }
   
   /** Test setName(). **/
   @Test public void setNameTest() {
   
      StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
      String name = "Dalton Price";
      sr.setName(name);
      Assert.assertEquals(sr.getName(), name);
   
   }
   
   /** Test getNumOfNights() **/
   @Test public void getNumOfNightsTest() {
    
      StandardRoom sr = new StandardRoom("Dalton Price", 5, 2);
      int numOfNights = sr.getNumOfNights();
      Assert.assertEquals(5, numOfNights);
      
   }
   
   /** Test setumOfNights(). **/
   @Test public void setNumOfNightsTest() {
   
      StandardRoom sr = new StandardRoom("Dalton Price", 5, 2);
      int numOfNights = 5;
      sr.setNumOfNights(numOfNights);
      Assert.assertEquals(sr.getNumOfNights(), 5);
   
   }
   
   @Test public void getNumOfPeopleTest() {
    
      StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
      int numOfPeople = sr.getNumOfPeople();
      Assert.assertEquals(2, numOfPeople);
      
   }
   
   /** Test setName(). **/
   @Test public void setNumOfPeopleTest() {
   
      StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
      int numOfPeople = 2;
      sr.setNumOfPeople(numOfPeople);
      Assert.assertEquals(sr.getNumOfPeople(), numOfPeople);
   
   }
   
   /** Test calculateTotal() **/
   @Test public void calculateTotalTest() {
      
      StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
      int numOfNights = 1;
      sr.setNumOfNights(numOfNights);
      sr.calculateTotal(numOfNights);
      Assert.assertEquals(sr.calculateTotal(numOfNights), 100.00, 0.0001);
    
    }
    
    /** Test addSR() **/
    @Test public void addSRTest() {
       
       Map<String, StandardRoom> srMap = new LinkedHashMap<String, StandardRoom>();
       StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
       String name = sr.getName();
       sr.getNumOfNights();
       sr.getNumOfPeople();
       sr.addSR(name);
       Map<String, StandardRoom> m = sr.getList();
       Assert.assertEquals(sr.getList(), m);
       
     }
     
     /** Test cancelSR() **/
     @Test public void cancelSRTest() {
         
       Map<String, StandardRoom> srMap = new LinkedHashMap<String, StandardRoom>();
       StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
       String name = sr.getName();
       sr.cancelSR(name);
       Map<String, StandardRoom> m = sr.getList();
       Assert.assertEquals(sr.getList(), m);
       
      }
      
      /** Test SummaryInfo() **/
      @Test public void summaryInfoTest() {
         
         StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
         String info = sr.summaryInfo();
         Assert.assertEquals(info, sr.summaryInfo());
         
       }
       
       /** Test toString() **/
      @Test public void toStringTest() {
         
         StandardRoom sr = new StandardRoom("Dalton Price", 1, 2);
         String info = sr.toString();
         Assert.assertEquals(info, sr.toString());
         
       }

      
               
   


      
         
      
     
      
      



   

   

   /**
   //test to check appraisal
   @Test
   public void testCalculateAppriasal() {
      employee.setName("Rajeev");
      employee.setAge(25);
      employee.setMonthlySalary(8000);
		
      double appraisal = empBusinessLogic.calculateAppraisal(employee);
      assertEquals(500, appraisal, 0.0);
   }

   // test to check yearly salary
   @Test
   public void testCalculateYearlySalary() {
      employee.setName("Rajeev");
      employee.setAge(25);
      employee.setMonthlySalary(8000);
		
      double salary = empBusinessLogic.calculateYearlySalary(employee);
      assertEquals(96000, salary, 0.0);
   }
   */
}


