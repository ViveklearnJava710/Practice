package StringQuestions;

public class RunTimeEncoding {
  
  
  

  public static void main(String[] args) {

    String str="wwwxxxzzzzzrrryttt" ; 
    runtime_encoding(str) ;
    
    str ="t";
    runtime_encoding(str) ;

  }

  private static void runtime_encoding(String str) {
    
    if(str.length() == 1 ) {
      System.out.println(str + "1" );
      return ; 
    }
    
    for(int i=0 ; i< str.length() ; i++ ) {
      
      int count = 1 ;
      
      while (i < str.length()-1 && str.charAt(i)== str.charAt(i+1)) {
        i++ ;
        count++ ;
      }
      
   // Print character and its count
      System.out.print(str.charAt(i));
      System.out.print(count);
    }
    
  }

}
