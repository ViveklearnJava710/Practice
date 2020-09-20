package Array;

import java.util.Arrays;
import java.util.List;

public class RepeatingNumbers {
  
  public static void main(String[] args ) {
    
    
    List<Integer> list = Arrays.asList(1,3,23,11,44,3,23,2,3) ;
    
    Integer[] array = new Integer[50] ;
    
    for (int i =0 ; i< array.length ; i++ )
    {
      array[i] = 0 ; 
    }
    
    for(Integer a : list ) {
      ++array[a] ;
    }
    
    for (int i =0 ; i< array.length ; i++ )
    {
      if(array[i] > 1)
      {
        System.out.println("Print Number " + i );
      }
    }
  }

}
