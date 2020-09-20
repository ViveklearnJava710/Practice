package JavaQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiList {

  public static void main(String[] args) {
    List<List<String>> multiList = new ArrayList<>();
    List<String> names= Arrays.asList("a","b");
    List<String> fewMoreNames= Arrays.asList("e","f");
    multiList.add(names);
    multiList.add(fewMoreNames);
    
   // multiList .stream().forEach((x) -> x.stream().forEach(System.out::println));
    
    multiList .stream().flatMap(List::stream).forEach(System.out::println);
    
    

  }

}
