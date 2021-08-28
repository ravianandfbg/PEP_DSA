import java.io.*;
import java.util.*;

public class Main {


  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();
    int k = scn.nextInt();

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }

    combination(0, k, -1, ustr, "");
  }


  public static void combination(int ssf, int ts, int lb, String ustr, String asf ) {
      if(ssf == ts){
          System.out.println(asf);
      return;
      }
      for(int idx = lb + 1 ; idx < ustr.length() ; idx++){
      char ch = ustr.charAt(idx);
      combination(ssf + 1 , ts , idx , ustr , asf + ch);
  }
  }

}