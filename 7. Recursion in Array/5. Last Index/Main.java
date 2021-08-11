import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int arr[] = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        
        System.out.println(lastIndex(arr,0,x));
        
        
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == arr.length){
            return -1;
        }
        
        int rres = lastIndex(arr, idx+1, x); //rres : recursive result
        
        if(rres == -1){
            // last occurrance has not been figured out
            if(arr[idx] == x){
                rres = idx;
            }
        }
        return rres;
    }

}