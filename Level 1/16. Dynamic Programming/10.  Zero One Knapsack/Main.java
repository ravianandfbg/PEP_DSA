import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int vls[] = new int[n]; // vls : values
        for(int i = 0 ; i < n ; i++){
            vls[i] = scn.nextInt();
        }
        
        int wts[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            wts[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt(); //cap : capacity
        
        //logic
        
        int dp[][] = new int[n+1][cap+1];
        
        for(int i = 1 ; i <= n ; i++){
            int wt = wts[i-1];
            int val = vls[i-1];
            
            for(int j = 1 ; j <= cap ; j++){
                dp[i][j] = dp[i-1][j]; //exclude
                if(j >= wt){
                    //include
                    dp[i][j] = Math.max(dp[i-1][j-wt] + val , dp[i][j]);
                }
            }
        }
        System.out.println(dp[n][cap]);

    }
}