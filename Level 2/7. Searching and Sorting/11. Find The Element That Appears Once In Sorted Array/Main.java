// Binary Search

// time : O(log n)            Space : O(1)

import java.util.*;
import java.io.*;

public class Main {

  public static int findSingleElement(int[]arr) {
    //write your code here
    if(arr[0] != arr[1]){
            return arr[0];
        }
        int n = arr.length;
        
        if(arr[n - 1] != arr[n - 2]){
            return arr[n - 1];
        } 
        
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            
            // if arr[mid] is single element
            if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
                return arr[mid];
            }
            else if(arr[mid] == arr[mid - 1]){
                // lo to mid -> left part
                // mid + 1 to hi -> right part
                
                int lc = mid - lo + 1; // lc : left count
                
                if(lc % 2 == 0){
                    lo = mid + 1;
                }
                else{
                    hi = mid + 2;
                }
            }
            else if(arr[mid] == arr[mid + 1]){
                // lo to mid-1 -> left part
                // mid to hi -> right part
                
                int rc = hi - mid + 1; // rc : right count
                
                if(rc % 2 == 0){
                    hi = mid - 1;
                }
                else{
                    lo = mid + 2;
                }
            }
        }
        return -1;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    int ans = findSingleElement(arr);
    System.out.println(ans);
  }
}