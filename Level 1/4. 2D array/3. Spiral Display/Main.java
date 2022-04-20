import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt(); // nr : no. of rows
        int nc = scn.nextInt(); // nc : no. of column
        int[][] arr = new int[nr][nc];
        
        for(int i = 0 ; i < nr ; i++){
            for(int j = 0 ; j < nc ; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int rmin = 0; // rmin : row minimum
        int rmax = nr - 1; // rmax : row maximum
        int cmin = 0; // cmin : column minimum
        int cmax = nc - 1; // cmax : column maximum
        int count = 0;
        int p = nr * nc;
        
        while(count < p){
            // left wall : top to bottom
            for(int i = rmin , j = cmin ; i <= rmax && count < p; i++){
                System.out.println(arr[i][j]);
                count++;
            }
            cmin++;
            
            // bottom wall : left to right
            for(int i = rmax , j = cmin ; j <= cmax && count < p ; j++){
                System.out.println(arr[i][j]);
                count++;
            }
            rmax--;
            
            // right wall : bottom to top
            for(int i = rmax , j = cmax ; i >= rmin && count < p ; i--){
                System.out.println(arr[i][j]);
                count++;
            }
            cmax--;
            
            // top wall : right to left
            for(int i = rmin , j = cmax ; j >= cmin && count < p ; j--){
                System.out.println(arr[i][j]);
                count++;
            }
            rmin++;
        }
    }

}