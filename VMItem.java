/**
 * A class to represent an item sold in a vending machine
 * Characteristics:
 *    Name: name of item for sale (example: Oreos)
 *    Cost: cost of item (ex. 2.95)
 *    Location: location code of item in vending machine (example: A7)
 *              (aka the code a customer types to tell machine which item to dispense)
 *    Amount: amount of items available in vending machine (example: 10)
 */
public class VMItem {
   
   /** instance variables */
   private String name = "";
   private double cost = 0.0;
   private String location = "";
   private int amount = -1;
   
   /**
    * constructor to create a VMItem
    *
    * @param      name              name of item (example:  oreos)
    * @param      cost              cost of item (example:  2.95)
    * @param      location          code for item row/column in vending machine (example: A7)
    * @param      amount            number available for purchase (example: 10)
    * @exception  VMItemException   name must be at least 5 characters
    * @exception  VMItemException   cost must be at least $1.00
    * @exception  VMItemException   location code must be 2 characters
    * @exception  VMItemException   amount must be between 0 - 15
    */
   public VMItem(String name, double cost, String location, int amount) throws VMItemException {
      this.setName(name);
      this.setCost(cost);
      this.setLocation(location);
      this.setAmount(amount);
   }
   
   /** accessor/get methods */
   public String getName() {
      return this.name;
   }
   
   public double getCost() {
      return this.cost;
   }
   
   public String getLocation() {
      return this.location;
   }
   
   public int getAmount() {
      return this.amount;
   }
   
   /** mutator/set methods */
   public void setName(String newName) throws VMItemException {
      if (newName.length() >= 5) {
         this.name = newName;
      }
      else {
         VMItemException vmie = new VMItemException();
         vmie.setMessage("ERROR! Item name must be at least 5 characters long");
         throw vmie;
      }
   }
   
   public void setCost(double newCost) throws VMItemException {
      if (newCost >= 1) {
         this.cost = newCost;
      }
      else {
         VMItemException vmie = new VMItemException();
         vmie.setMessage("ERROR! Item cost must be at least $1.00");
         throw vmie;
      }
   }
   
   public void setLocation(String newLocation) throws VMItemException {
      if (newLocation.length() == 2) {
         this.location = newLocation;
      }
      else {
         VMItemException vmie = new VMItemException();
         vmie.setMessage("ERROR! Location code should only be 2 characters");
         throw vmie;
      }
   }
   
   public void setAmount(int newAmount) throws VMItemException {
      if (newAmount >= 0 && newAmount <= 15) {
         this.amount = newAmount;
      }
      else {
         VMItemException vmie = new VMItemException();
         vmie.setMessage("ERROR! Amount should be a positive number no greater than 15.");
         throw vmie;
      }
   }
   
   /**
    * Returns a printable string when the object is printed
    * Example:
    *    Oreos       $2.95       A7       10 units for sale
    *
    * @return     msg      a string containing item information
    */
   public String toString() {
      String msg = "";
      msg += "Item name: " + this.name;
      msg += "\nItem cost: $" + this.cost;
      msg += "\nLocation code: " + this.location;
      msg += "\nAmount available: " + this.amount + " units for sale";
      if (this.amount == 0) {
         msg += "\t*** PLEASE RESTOCK ***";
      }
      return msg;
   }
}