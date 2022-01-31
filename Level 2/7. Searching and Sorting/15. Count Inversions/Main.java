// Time : O(N log N) (same complexity as merge sort)    Space : O(N)

// Merge Sort approch

import java.util.*;
import java.io.*;

public class Main {
    
    static int count = 0; // total inversion
    public static int inversionCount(int arr[], int N)
    {
        // Your Code Here
        count = 0;
        mergeSort(arr , 0 , N-1);
        return count;
    }
    
    public static int[] merge2SortedArrays(int[] left , int[] right){
        int n = left.length;
        int m = right.length;
        int[] ma = new int[n+m]; // ma : merged array
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < n && j < m){
            if(left[i] <= right[j]){
                ma[k] = left[i];
                i++;
                k++;
            }
            else{
                // calculate inversions
                count += (n - i);
                
                ma[k] = right[j];
                j++;
                k++;
            }
        }
        
        while(i < n){
            ma[k] = left[i];
            i++;
            k++;
        }
        
        while(j < m){
            ma[k] = right[j];
            j++;
            k++;
        }
        return ma;
    }
    
    public static int[] mergeSort(int[] arr , int lo , int hi){
        if(lo == hi){
            int[] ba = new int[1];
            ba[0] = arr[lo];
            return ba;
        }
        int mid = (lo + hi) / 2;
        int[] la = mergeSort(arr , lo , mid); // la : left array
        int[] ra = mergeSort(arr , mid + 1 , hi); // ra : right array
        
        return merge2SortedArrays(la , ra);
    }

    public static void main(String[]args) {
        //write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println(inversionCount(arr , n));
    }
}