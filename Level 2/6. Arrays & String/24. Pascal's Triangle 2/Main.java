import java.util.*;

public class Main {

  // ~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
  public static ArrayList<Integer> pascalRow(int n) {
    // write your code here
    ArrayList<Integer> ans = new ArrayList<>();
        
        long val = 1; //nC0
        ans.add(1);
        
        for(int r = 0 ; r < n ; r++){
            val = (val * (n - r)) / (r + 1);
            ans.add((int)val);
        }
        return ans;
  }

  // ~~~~~~~~~~~Input management~~~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    ArrayList<Integer> res = pascalRow(n);
    for (int val : res) {
      System.out.print(val + " ");
    }
    System.out.println();
  }
}