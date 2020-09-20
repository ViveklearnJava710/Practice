package JavaQuestion.myCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet<T> {
  
  /* https://blog.miyozinc.com/algorithms/custom-hashmap-implementation-in-java/ */ 
  /* https://www.youtube.com/watch?v=NrMaQL_4Npo&t=245s */ 
  private static final int ARRAY_SIZE = 100 ;
  private List<List<T>> parentList ;
  
  public MyHashSet() {
    MyHashSet(ARRAY_SIZE) ;
  }
  
  private void MyHashSet(int arraySize) {
    parentList = new ArrayList<>(arraySize) ;
    parentList.stream().forEach(e -> e.add(null));
    
  }

  public void add(T value) {
    int index = hash(value) % ARRAY_SIZE ;
    List<T> childList ;
    if((childList = parentList.get(index)) == null ) {
      childList = new LinkedList<>() ;
      childList.add(value) ;
      parentList.add(index , childList) ;
    }else
    {
      if(!childList.contains(value))
      {
        childList.add(value) ;
      }
    }
  }
  
  public Boolean remove (T value ) {
    int index = hash(value) % ARRAY_SIZE ;
    List<T> childList = parentList.get(index) ;
    if(childList == null ) {
      return false ; 
    }else {
      return childList.remove(value) ;
    }  
  }
  
  static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

}
