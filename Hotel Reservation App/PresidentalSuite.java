import java.util.*;
import java.text.*;
import java.time.*;

/**
*Presidental Suite reservation and info.
*/
public class PresidentalSuite {
   
   //variables
   private String name;
   private Map<String, PresidentalSuite> psMap = new LinkedHashMap<String, PresidentalSuite>();
   private static final double PS_PRICE = 200.00;
   private static final double SR_PRICE = 100.00;
   private static final int MAX_NIGHTS = 5;
   private static final int MAX_PEOPLE = 4;
   private int numOfNights = 0;
   private int numOfPeople = 0;
   private boolean inputGood = false;
   
   //decimal format
   private DecimalFormat df = new DecimalFormat("#,##0.00");
   
   //date
   private long millis = System.currentTimeMillis();  
   private java.sql.Date date = new java.sql.Date(millis);  
   
   //scanner
   private Scanner scan = new Scanner(System.in);
   
   /**
   *PresidentalSuite constructor.
   *@param numOfNights the number of nights.
   *@param name the name of person.
   *@param numOfPeople the number of people.
   */

   public PresidentalSuite(String name, int numOfNights, int numOfPeople) {
      
      this.name = name;
      this.numOfNights = numOfNights;
      this.numOfPeople = numOfPeople;
   }
   
   /**
   *Get the name for reservation.
   *@return name name of person.
   */
   public String getName() {
      
      return name;
   
   }
   
   /**
   *Set the name for reservation.
   *@param name the name of person.
   */
   public void setName(String name) {
      
      this.name = name;
      
   }
   
   /**
   *Get the number of nights.
   *@return numOfNights.
   */
   public int getNumOfNights() {
      
      return numOfNights;
   
   }
   
   /**
   *Set the number of nights.
   *@param numOfNights the number of nights.
   */
   public void setNumOfNights(int numOfNights) {
      
      this.numOfNights = numOfNights;
      
   }
   
   /**
   *Get the number of people.
   *@return numOfPeople num of people.
   */
   public int getNumOfPeople() {
      
      return numOfPeople;
   
   }
   
   /**
   *Set the number of people.
   *@param numOfPeople the number of people.
   */
   public void setNumOfPeople(int numOfPeople) {
      
      this.numOfPeople = numOfPeople;
      
   }

   
   /**
   *Calculate the total cost for reservation.
   *@param numOfNights the number of nights.
   *@return total the total cost.
   */
   public double calculateTotal(int numOfNights) {
      
      double total = PS_PRICE * numOfNights;
      return total;
      
   }
    
   /**
   *Add reservation for Presidental suite.
   *@param nameIn the name of person.
   */ 
   public void addPS(String nameIn) {
      
      inputGood = false;
      while (!inputGood) { 
       
         System.out.println("First and last name for the reservation: ");
     
         try { 
    
            nameIn = scan.nextLine(); 
            if (!nameIn.contains(" ") || nameIn.isEmpty()) {
               throw new Exception("ERROR: You need to enter a first and last name!");
            }
            else {
               inputGood = true;           
            }
         }   
         catch (InputMismatchException e) {
            System.out.println("Response must be a first and last name!");
         } 
         catch (Exception e) {
            System.out.println(e.getMessage());     
         } 
                 
      }
   
      inputGood = false;     
      while (!inputGood) {    
   
         System.out.println("How many nights will you be staying: ");
       
         try {  
       
            numOfNights = scan.nextInt();
            scan.nextLine();
              
            if (numOfNights <= 0) {
               throw new NumberFormatException();
            }
            else if (numOfNights > MAX_NIGHTS) {
               throw new Exception("NOTE: You cannot reserve room for more than 5 days!");
            }
            else {
               inputGood = true;         
            }
    
         }
         catch (NumberFormatException e) {
            System.out.println("ERROR: Response must be a positive number!");   
         } 
         catch (InputMismatchException e) {
            System.out.println("ERROR: Response must be a number!");
            scan.nextLine();
         }   
         catch (Exception e) {
            System.out.println(e.getMessage());          
         }
         
      }         
   
      inputGood = false;
      while (!inputGood) {        
         System.out.println("How many people total: ");
   
         try {    
            numOfPeople = scan.nextInt();
            scan.nextLine();
              
            if (numOfPeople <= 0) {
               throw new NumberFormatException();
            }
            else if (numOfPeople > MAX_PEOPLE) {
               throw new Exception("NOTE: You cannot have more than 4 people to one room!");
            }
            else {
               inputGood = true;
            }

         }
         catch (NumberFormatException e) {
            System.out.println("ERROR: Response must be a positive number!");
         }
         catch (InputMismatchException e) {
            System.out.println("ERROR: Response must be a number!");
            scan.nextLine();
         }    
         catch (Exception e) {
            System.out.println(e.getMessage());                
         }         
      }
  
      inputGood = false;
      while (!inputGood) {
         try {  
            System.out.println("Your total will be " + "$" + df.format(calculateTotal(numOfNights)) + "."
               + "\nPress 1 to accept and confirm reservation.");
       
            int confirm = scan.nextInt();
            scan.nextLine();
            if (confirm == 1) {
               inputGood = true;
               psMap.put(nameIn, new PresidentalSuite(nameIn, numOfNights, numOfPeople));
               System.out.println("Presidental Suite reservation for " + nameIn + " created!"
                  + "\nName on reservation: " + getName()
                  + "\nNumber of nights reserved: " + getNumOfNights() 
                  + "\nTotal Price: $" + df.format(calculateTotal(numOfNights)) 
                  + "\nNumber of people: " + getNumOfPeople() + "\n");  
            }
            else {     
               System.out.println("Reservation process cancelled.");
            }
         }
         catch (InputMismatchException e) {
            System.out.println("ERROR: Please enter 1 to confirm reservation or any other number to cancel.");
            scan.nextLine();
         }
      }
   }
      
   /**
   *Cancel reservation for Presidental suite.
   *@param nameIn the name of reservation.
   */
   public void cancelPS(String nameIn) {
    
      inputGood = false;
      while (!inputGood) {  
         System.out.println("Name of the reservation: ");
      
         try {    
            name = scan.nextLine();
      
            if (!name.contains(" ") || name.isEmpty()) {
               throw new Exception("ERROR: You need to enter a first and last name!");
            }
            else {
               inputGood = true;           
            }
         }   
         catch (InputMismatchException e) {
            System.out.println("Response must be a first and last name!");
         } 
         catch (Exception e) {
            System.out.println(e.getMessage());     
         } 
                 
      }
   
      if (psMap.containsKey(name)) {
          
         psMap.remove(name);
         System.out.println("Reservation for " + getName() + " cancelled"
             + "\nYour payment of $" + df.format(calculateTotal(numOfNights)) + " will be refunded.");
       
      }
      else {
          
         System.out.println("Reservation not found");
          
      }
   }
    
   /**
   *Print all the info of reservation.
   *@return result the res info.
   */ 
   public String summaryInfo() {
   
      df = new DecimalFormat("$#,##0.00");
      String result = "";
      result = "----- Booking Info for " + getName() + "'s Presidental Suite -----";
      result += "\nName of Bookee: " + getName();
      result += "\nTotal Price: " + df.format(calculateTotal(numOfNights)) + " USD Dollars";
      result += "\nLength of rental: " + getNumOfNights() + " days"; 
      result += "\nNumber of people: " + getNumOfPeople();
      result += "\nDate reserved: " + date + "\n";
      return result;
   }
   
   /**
   *Print out the map.
   *@return srMap the SR HashMap.
   */ 
   public Map<String, PresidentalSuite> getList() {
      
      return psMap;
      
   }

   /**
   *Loop through map values and print toString() for each.
   */ 
   public void showPS() {
       
      for (PresidentalSuite PS : psMap.values()) {
          
         System.out.println(PS.toString());
      }
        
   }
    
   /**
   *Overriden toString method.
   *@return summaryInfo() the summary info method.
   */
   public String toString() {
       
      return summaryInfo();
       
   }
    
      
   
}

