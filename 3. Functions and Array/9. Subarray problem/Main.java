import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
        }
        for(int sp = 0; sp < arr.length; sp++) //sp = starting point
        {
            for(int ep = sp; ep < arr.length; ep++) //ep = end point
            {
                for(int i = sp; i <= ep; i++)
                {
                    System.out.print(arr[i]+"	");
                }
                System.out.println();
            }
        }
        
    }

}