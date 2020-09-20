package MultiThreading;

public class PrintPattern {
  
  
  
  public static void main (String [] args) {
  
  StateObject obj = new StateObject("A") ;
  
  
  for (int i=0 ; i< 10 ; i++ ) {
  
  new Thread( new Runnable() { 
    @Override
    public void run() {
        synchronized (obj) {
          while(obj.getState().equals("A")) {
            try {
              System.out.println("Welcome ");
              obj.setState("B");
              obj.wait();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
          obj.notifyAll();
          
        } 
    }
  } ).start() ;
  
 new Thread( new Runnable() {
    
   @Override
   public void run() {
       synchronized (obj) {
         
         while(obj.getState().equals("B")) {
           try {
             System.out.println("To Bravura ");
             obj.setState("C");
             obj.wait();
           } catch (InterruptedException e) {
             e.printStackTrace();
           }
         }
         obj.notifyAll();
         
       }    
     
   }
  } ).start() ;
 
 
 new Thread( new Runnable() {
   
   @Override
   public void run() {
     
       synchronized (obj) {
         while(obj.getState().equals("C")) {
           try {
             System.out.println("Vivek  ");
             obj.setState("A");
             obj.wait();
           } catch (InterruptedException e) {
             e.printStackTrace();
           }
         }
         obj.notifyAll();
         
       }
       
   }
 } ).start() ;
 
}
  }

}
