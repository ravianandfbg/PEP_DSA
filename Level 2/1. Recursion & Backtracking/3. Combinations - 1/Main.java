import java.io.*;
import java.util.*;

public class Main {

    //ssf : selection so far
    //cb : current box
    //tb : total box
    //ts : total selection
  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    // write your code here
    if(cb > tb){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;
    }
    combinations(cb+1 , tb , ssf+1 , ts , asf+"i"); // object placed
    combinations(cb+1 , tb , ssf , ts , asf+"-"); // object unplaced
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}