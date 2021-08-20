import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        //TABULATION
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] moves = new int[n];
        for(int i = 0 ; i < n ; i++){
            moves[i] = scn.nextInt();
        }
        
        //logic
        int dp[] = new int[n+1];
        for(int i = n ; i >= 0 ; i--){
            
        if(i == n){
            dp[i] = 1;
        }
        
        else{
            int maxJump = moves[i];
            for(int len = 1 ; len <= maxJump && len+i <= n ; len++){
                dp[i] += dp[i+len];
            }
        }
     }
        
        System.out.println(dp[0]);
    }

}