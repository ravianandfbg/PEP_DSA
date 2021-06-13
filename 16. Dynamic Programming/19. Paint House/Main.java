import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][3];
        
        for(int i = 0 ; i < n ; i++){
            arr[i][0] = scn.nextInt(); //for Red
            arr[i][1] = scn.nextInt(); //For Blue
            arr[i][2] = scn.nextInt(); //For Green
        }
        
        //logic
        
        int oCostRed = arr[0][0] , oCostBlue = arr[0][1] , oCostGreen = arr[0][2]; 
        
        for(int h = 1; h < n; h++){
            
            int nCostRed = arr[h][0] + Math.min(oCostBlue , oCostGreen);
            int nCostBlue = arr[h][1] + Math.min(oCostRed , oCostGreen);
            int nCostGreen = arr[h][2] + Math.min(oCostRed , oCostBlue);
            
            oCostRed = nCostRed;
            oCostBlue = nCostBlue;
            oCostGreen = nCostGreen;
        }
        
        int minCost = Math.min(oCostRed , Math.min(oCostBlue , oCostGreen));
        
        System.out.println(minCost);
        
    }
}