package MultiThreading;

class CountDown {
  
  int count ;
  
  public CountDown(int count) {
    super();
    this.count = count;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  } 
  
  public void countDown() {
    -- this.count ; 
  }
  
}

class WorterThread  implements Runnable  {
  
  CountDown countDown ;

  public WorterThread(CountDown countDown) {
    super();
    this.countDown = countDown;
  }

  @Override
  public void run() {
    synchronized (countDown) {
      
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      System.out.println("Counting Down ");
      countDown.countDown(); 
      countDown.notifyAll();
      
    }
    
  } 
  
}


class WaitingThread  implements Runnable  {
  
  CountDown countDown ;

  public WaitingThread(CountDown countDown) {
    super();
    this.countDown = countDown;
  }

  @Override
  public void run() {
    synchronized (countDown) {
      
      while(countDown.getCount() != 0) {
        try {
          countDown.wait();
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        
      }
      
      System.out.println("I am Done");
      
    }
    
  } 
  
}

public class MyCountDownLatch {

  public static void main(String[] args) {
    
    CountDown countDown  = new CountDown(3) ;
    
    new Thread(new WorterThread(countDown)).start(); ;
    new Thread(new WorterThread(countDown)).start() ;
    new Thread(new WorterThread(countDown)).start() ;
    
    new Thread(new WaitingThread(countDown)).start(); ;
     
  }

}
