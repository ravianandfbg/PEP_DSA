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
    permutations(ustr , 0, new Character[k], 0);
   
  }
  public static void permutations(String ustr , int idx , Character[] spots , int count){
      if(idx == ustr.length()){
          if(count == spots.length){
              for(Character ch : spots){
                  System.out.print(ch);
              }
              System.out.println();
          }
          return;
      }
      
      char ch = ustr.charAt(idx);
      for(int i = 0; i < spots.length ; i++){
          if(spots[i] == null){
              spots[i] = ch;
              permutations(ustr , idx+1 , spots , count+1);
              spots[i] = null;
          }
      }
      permutations(ustr , idx+1 , spots , count);
  }

}