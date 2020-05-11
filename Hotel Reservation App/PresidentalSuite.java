import java.util.*;
import java.text.*;
import java.time.*;
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
   DecimalFormat df = new DecimalFormat("#,##0.00");
   
   //date
   long millis=System.currentTimeMillis();  
   java.sql.Date date=new java.sql.Date(millis);  
   
   //scanner
   Scanner scan = new Scanner(System.in);
   
   public PresidentalSuite(String name, int numOfNights, int numOfPeople) {
      
      this.name = name;
      this.numOfNights = numOfNights;
      this.numOfPeople = numOfPeople;
   }
   
   //get name
   public String getName() {
      
      return name;
   
   }
   
   //set name
   public void setName(String name) {
      
      this.name = name;
      
   }
   
   //get num of nights there
   public int getNumOfNights() {
      
      return numOfNights;
   
   }
   
   //set num of nights
   public void setNumOfNights(int numOfNights) {
      
      this.numOfNights = numOfNights;
      
   }
   
   //get num of people
   public int getNumOfPeople() {
      
      return numOfPeople;
   
   }
   
   //set num of people
   public void setNumOfPeople(int numOfPeople) {
      
      this.numOfPeople = numOfPeople;
      
   }

   
   //calculate total cost for staying in Pres suite
    public double calculateTotal(int numOfNights) {
      
      double total = PS_PRICE * numOfNights;
      return total;
      
    }
    
   //add PS reservation()
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
      while(!inputGood) {        
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
    
    
    //cancel PS res
    public void cancelPS(String nameIn) {
    
    inputGood = false;
    while(!inputGood) {  
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
    
    //summary info 
    public String summaryInfo() {
   
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      String result = "";
      result = "----- Booking Info for " + getName() + "'s Presidental Suite -----";
      result += "\nName of Bookee: " + getName();
      result += "\nTotal Price: " + df.format(calculateTotal(numOfNights)) + " USD Dollars";
      result += "\nLength of rental: " + getNumOfNights() + " days"; 
      result += "\nNumber of people: " + getNumOfPeople();
      result += "\nDate reserved: " + date + "\n";
      return result;
   }
   
    public Map<String, PresidentalSuite> getList() {
      
      return psMap;
      
    }

    
    public void showPS() {
       
       for (PresidentalSuite PS : psMap.values()) {
          
          System.out.println(PS.toString());
       }
        
    }
    
    //to string to fix printed format
    public String toString() {
       
        return summaryInfo();
       
    }
    
      
   
}

