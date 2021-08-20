import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
          
          Scanner scn = new Scanner(System.in);
          int n = scn.nextInt();
          
          int ways = climbStairs(n , new int[n+1]);
          System.out.println("MEMORIZATION :- " +ways);

          int way = climbStairsTabulation(n);
          System.out.println("TABULATION :- " +way);
      }
      
      // Method 1 :- MEMORIZATION
    
    public static int climbStairs(int n , int dp[]){
        if(n == 0){
            return dp[n] = 1;
        }
        
        if(dp[n] != 0){
            return dp[n];
        }
        
        int tways = 0; // tways : total ways
        if(n-1 >= 0){
            tways += climbStairs(n-1 , dp); //1 len
        }
        if(n-2 >= 0){
            tways += climbStairs(n-2 , dp); // 2 len
        }
        if(n-3 >= 0){
            tways += climbStairs(n-3 , dp); // 3 len
        }
    return dp[n] = tways;
    } 


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~//

    // Method 2 :- TABULATION

    public static int climbStairsTabulation(int n){
        int[] dp = new int[n+1];
        
        for(int i = 0 ; i <= n ; i++){
            if(i == 0){
                dp[0] = 1;
            }
            else if(i == 1){
                dp[i] = dp[i-1];
            }
            else if(i == 2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }
    
}