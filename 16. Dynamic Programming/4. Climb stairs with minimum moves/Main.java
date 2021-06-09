import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] moves = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scn.nextInt();
        }
        
         Integer[] dp = new Integer[n + 1];
      dp[n] = 0;

      for (int i = n - 1; i >= 0; i--) {
         if (moves[i] > 0) {
            int min = Integer.MAX_VALUE;

            for (int len = 1; len <= moves[i] && i + len < dp.length; len++) {
               if(dp[i + len] != null){
                  min = Math.min(min, dp[i + len]);
               }
            }

            if(min != Integer.MAX_VALUE){
               dp[i] = min + 1;
            }
         }
      }

      System.out.println(dp[0]);
   }

}








