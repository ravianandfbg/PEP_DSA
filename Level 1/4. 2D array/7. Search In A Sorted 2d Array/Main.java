import java.io.*;
import java.util.*;

public class Main {

      public static void main(String[] args) throws Exception {
            // write your code here
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < arr.length; i++) {
                  for (int j = 0; j < arr[0].length; j++) {
                        arr[i][j] = scn.nextInt();
                  }
            }
            int element = scn.nextInt();
            searchElement(arr, element);
      }

    public static boolean searchElement(int[][] arr , int element){
        int n = arr.length;
        
        int i = 0 , j = n-1; //no.of column - 1
        while(i <= n-1 && j >= 0){
            int val = arr[i][j];
            
            if(element < val){
                // search in smaller region
                j--;
            }
            else if(element > val){
                //search in larger region
                i++;
            }
            else{
                //element found
                System.out.println(i+ " " +j);
                return true;
            }
        }
        System.out.println("Not Found");
        return false;
    }

}