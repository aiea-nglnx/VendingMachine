# VendingMachine

A program that will control a vending machine. A custom Java class named VMItem that throws a custom exception. Each instance of VMItem will represent an item that is for sale in the vending machine.

The self-validating VMItem class will have the following instance variables:

   - A variable that will represent the name of the item
   - A variable that will represent the cost of the item
   - A variable that represents the location code of the item in the vending machine
   - A variable that represents the amount of the item available in the machine

Driver Class has 3 methods
   - fillVendingMachine method
      - Create an array or ArrayList  to store information on what items are in the vending machine.
      - Pass the array/ArrayList and the item code to the purchaseItem method.
   - purchaseItem
      - Use a loop to examine each item in your array/ArrayList until you find the VMItem object that was requested.
   - displayItems
     - Prints out the ArrayList in order with VMItems objects
