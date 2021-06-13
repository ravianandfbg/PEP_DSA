import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        //logic
        int first = 1 , second = 1; 
        int dp[] = new int[n+1];
        
        for(int i = 2 ; i <= n ; i++){
            int third = second + ((i-1)*first);
            
            first = second;
            second = third;
        }
        
        System.out.println(second);
    }

}