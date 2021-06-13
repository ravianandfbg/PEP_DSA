import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] vls = new int[n];
        for (int i = 0; i < n; i++) {
            vls[i] = scn.nextInt();
        }

        int[] wts = new int[n];
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();
        
        //logic
        
        int[] dp = new int[cap + 1];
        for (int i = 1; i < dp.length; i++) {
           for(int j = 0; j < wts.length; j++){
               int val = vls[j];
               int wt = wts[j];

               if(i >= wt){
                   int factor = dp[i - wt] + val;
                   if(factor > dp[i]){
                       dp[i] = factor;
                   }
               }
           }
        }

        System.out.println(dp[cap]);
    }
}


                        