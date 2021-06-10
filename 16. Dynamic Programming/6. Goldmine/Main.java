import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        int[][] mines = new int[nr][nc];
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                mines[i][j] = scn.nextInt();
            }
        }
        
        //logic
        int[][] dp = new int[nr][nc];
        
        for(int c = 0 ; c < nc ; c++){
            for(int r = 0 ; r < nr ; r++){
                
                //for column 0
                if(c == 0){
                    dp[r][c] = mines[r][c];
                }
                
                // for 0th row
                else if(r == 0){
                    dp[r][c] = Math.max(dp[r][c-1] , dp[r+1][c-1]) + mines[r][c];
                }
                
                // for last row 
                else if(r == nr-1){
                    dp[r][c] = Math.max(dp[r][c-1] , dp[r-1][c-1]) + mines[r][c];
                }
                
                
                
                else{
                    dp[r][c] = Math.max(dp[r-1][c-1] , Math.max(dp[r][c-1] , dp[r+1][c-1])) + mines[r][c];
                }
            }
        }
        
        int max = dp[0][nc-1];
        for(int r = 0 , c = nc-1; r <= nr-1 ; r++){
            max = Math.max(max , dp[r][c]);
        }
        System.out.println(max);
        
        
    }

}