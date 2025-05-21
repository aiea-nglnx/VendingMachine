/**
 * A custom exception class for VMItem objects
 */
public class VMItemException extends Exception {
   
   /** instance variable */
   private String message = "";
   
   /** constructor */
   public VMItemException() {
   }
   
   /** accessor/get method */
   public String getMessage() {
      return this.message;
   }
   
   /** mutator/set method */
   public void setMessage(String newMessage) {
      this.message = newMessage;
   }
   
}