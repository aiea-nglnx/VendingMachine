import java.util.Scanner;
import java.util.ArrayList;


public class PaoAngelinaFINAL {
   private static ArrayList<VMItem> items;
   public static void main(String[] args) {
   
      // Declaring variables and initializing resources
      Scanner reader = new Scanner(System.in);
      String greetings = ""; // Stores the user's name
      String userResponse = ""; 
      String location = "";   
      double money = 0;
      double change = 0;
                   
      // Prompt the user to enter their name and greet them when the program runs
      System.out.print("Greetings, what's your name? ");
      greetings = reader.nextLine();
      System.out.println("\nHey " + greetings.toUpperCase() + "!" + 
            " This program will display delicious food and drinks presented in my vending machine.");
        
         
      // Calling the fillVendingMachine method
      items = fillVendingMachine();
      
      // Call the displayItems method to show inventory
      displayItems(items);
      
      // Ask the user if they want to pruchase an item
      System.out.println("\nDo you want to purchase an item?");
      System.out.print("\tPlease type yes or no: ");
      userResponse = reader.nextLine();

     // If user enters yes, they are prompted the following:
      if (userResponse.equalsIgnoreCase("yes")) {
         System.out.print("\tPlease type the item code: ");
         location = reader.nextLine(); // Get the item location
         
         VMItem selectedItem = purchaseItem(location);

         // Checks if the item stock is equal to 0
         if (selectedItem == null) {
            System.out.println("Oops! There is no item located at " + location + ".");
            System.out.println("Please check the vending machine inventory.");
         }
         else { // Gets the price of the item and cost if stock isn't equal to 0
            System.out.println("The price of " + selectedItem.getName() + " is $" + selectedItem.getCost() + ". Insert your cash now.");
            System.out.print("\tPlease type how much money was deposited: $");
            
            try { // Prompts user for their cash
               money = reader.nextDouble(); // Read the user's money input
               reader.nextLine();
            
               // Check if the user can afford it
               if (money >= selectedItem.getCost()) {
                  change = money - selectedItem.getCost(); // Calculate change
                  System.out.println("\nThank you. You may pick up your item in the dispenser below.");
                  System.out.printf("\nPlease don't forget to retrieve your change of $%.2f", change);
               }
               else {
                  System.out.println("Sorry customer, but you don't have enough money.");
               }
            }
            catch (java.util.InputMismatchException ime) {
               System.out.println("Invalid input, customer. Please enter a monetary value, like $2.99." +
                  "\nSorry, please try again.");
            }
         }
      }
      else if (userResponse.equalsIgnoreCase("no")) {
         System.out.println("\nOk, thank you for checking out my vending machine.");
         System.out.println("Hope you found what you were looking for.");
      }
   }

/**
 * A fillVendingMachine that prints out the ArrayList in order with VMItems objects separated
 * 
 * @param       none
 * @return      An ArrayList containing VMItem objects with preset data    
 * @exception   VMItemException if there is an issue initializing a VMItem object.
 */ 
   // fillVendingMachine method
   public static ArrayList<VMItem> fillVendingMachine() {
       // Create the ArrayList
      ArrayList<VMItem> itemList = new ArrayList<>();
      try {
          // Add items to the vending machine
         itemList.add(new VMItem("Cocoa Cola", 3.50, "A1", 1));
         itemList.add(new VMItem("Sprite", 3.00, "A2", 2));
         itemList.add(new VMItem("Lay's Ruffle Chips", 2.15, "B1", 5));
         itemList.add(new VMItem("Snicker's", 4.00, "C1", 3));
         itemList.add(new VMItem("Mocha Blended Drink", 4.50, "A3", 0));
      }
      catch (VMItemException vie) {
         System.out.println("Error initalizing vending machine: " + vie.getMessage());
      }
      // Return the ArrayList
      return itemList;
   }
  
/**
 * A displayItems method that prints out the ArrayList in order with VMItems objects separated
 * 
 * @param       items An ArrayList of VMItem objects representing vending machine inventory.
 * @return      none     
 * @exception   none
 */ 
   // displayItems method

   public static void displayItems(ArrayList<VMItem> items) {
      // Print the vending machine inventory
      System.out.println("Hopefully, I can provide you with whatever you need.");
      System.out.println("Here is what my machine can offer:");
      System.out.println("ITEM                 COST    CODE   # AVAIL.");
      System.out.println("====================================================");
   
      for (int i = 0; i < items.size(); i++) {
         VMItem item = items.get(i); // Get the VMItem object at index i
         System.out.printf("%-20s $%-6.2f %-6s %d\n",
            item.getName(), // Item name
            item.getCost(), // Item cost
            item.getLocation(), // Item code
            item.getAmount() // Item quantity
            );
         if (item.getAmount() == 0) {
            System.out.print("\t*** PLEASE RESTOCK ***");
         }
      }
   }
/**
 * A purchaseItem method that exmaines each item in the ArrayList until
 * it finds the VMItem object that was requested
 * 
 * @param       location The item code the user wants to purchase
 * @return      VMItem object if found, otherwise null.    
 * @exception   none
 */ 
   // purchaseItem method
   public static VMItem purchaseItem(String location) {
   
      // Loop through the vending machine items
      for (int i = 0; i < items.size(); i++) {
         VMItem item = items.get(i);
         
         // Check if the location matches
         if (item.getLocation().equals(location)) {
            // Prevent purchasing if the item is out of stock
            if (item.getAmount() == 0) {
               System.out.println("\nSorry! " + item.getName() + " is out of stock. We will restock soon.");
               return null;
            }
            return item;
         }
      }
      System.out.println("\nInvalid code. There is no item located at " + location + ".");
      return null;
   }

}
