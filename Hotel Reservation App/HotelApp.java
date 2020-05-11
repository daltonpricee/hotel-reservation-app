import java.util.*;
public class HotelApp {
   
   public static void main(String[] args) {
      
      //maps
      Map<String, StandardRoom> srMap = new LinkedHashMap<String, StandardRoom>();
      Map<String, PresidentalSuite> psMap = new LinkedHashMap<String, PresidentalSuite>();
      
      //variables
      String name = "";
      int numOfNights = 0;
      int numOfPeople = 0;
      int choice = 0;
      final double PS_PRICE = 200.00;
      final double SR_PRICE = 100.00;
      boolean validInput = false;
     
      //class instances
      StandardRoom SR = new StandardRoom(name, numOfNights, numOfPeople);
      PresidentalSuite PS = new PresidentalSuite(name, numOfNights, numOfPeople);
      //scanner
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Thank you for choosing to make your hotel reservation with us.\n");
      
   do {
       
      System.out.println("What can we help you with today?"
         + "\n1) Reserve Presidental Suite"
         + "\n2) Reserve Standard Room"
         + "\n3) Cancel Presidental Reservation"
         + "\n4) Cancel Standard Reservation"
         + "\n5) View Presidental List"
         + "\n6) View Standard List"
         + "\n7) Quit");      
   try {    
       choice = scan.nextInt();
       
    } catch (InputMismatchException e) {
          System.out.println("ERROR: Please enter a value from the menu or 7 to Quit.\n");
          scan.nextLine();
      }
      catch (NumberFormatException e) {
          System.out.println("ERROR: Please enter a positive number, or 7 to Quit.\n");
          scan.nextLine();
      } 
       
       switch (choice) {
         
          //create prez res
          case 1: 
         
             PS.addPS(name);
             break;
          
          //create standard res 
          case 2:
            
             SR.addSR(name);
             break;
          
          //cancel pres suite res              
          case 3:
            
            PS.cancelPS(name);                   
            break;
          
          //cancel standard res 
          case 4:
             
             SR.cancelSR(name);                  
             break;
          
          //view all pres reservations   
          case 5:
             
             PS.showPS();
             break;
             
          //view all standard reservations
          case 6:
             
             SR.showSR();
             break;
          
           case 7:
               
             System.out.println("Thank you for reserving with us. Come again!");
             break;
               
           default: 
             
              continue;   
            }
            
            
            }
            while (choice != 7);
       
         
      
      
      
   
   }



}