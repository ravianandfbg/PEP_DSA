import java.io.*;
import java.util.*;

public class Main {

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
    permutations(ustr , 0, k, new HashSet<>(), "");
  }
  
  public static void permutations(String ustr , int cs , int ts , HashSet<Character> charUsed , String asf){
      if(cs == ts){
          System.out.println(asf);
          return;
      }
      
      for(int i = 0 ; i < ustr.length() ; i++){
          char ch = ustr.charAt(i);
          if(charUsed.contains(ch) == false){
              charUsed.add(ch);
              permutations(ustr , cs + 1 , ts , charUsed , asf + ch);
              charUsed.remove(ch);
          }
      }
  }

}