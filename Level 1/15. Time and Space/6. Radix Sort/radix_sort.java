import java.io.*;
import java.util.*;

public class radix_sort {

  public static void radixSort(int[] arr) {
    // write code here 
    int max = Integer.MIN_VALUE;
    for(int val : arr){
        if(val > max){
            max = val;
        }
    }
    int count = 0;
    
    while(max != 0){
        count++;
        max = max/10; //find remainder
    }
    
    int exp = 1; //exp : exponent
    while(count != 0){
        countSort(arr,exp);
        count--;
        exp = exp * 10; //find digit
    }
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    
    //find frequency
    int freq[] = new int[10];
    for(int value : arr){
        freq[(value/exp)%10]++;
    }
    
    //psa : prefix sum array
    for(int i = 1 ; i < 10 ; i++){
        freq[i] += freq[i-1];
    }
    
    //find resultant
    
    int res[] = new int[arr.length];
    
    for(int idx = arr.length-1 ; idx >= 0 ; idx--){
        int val = arr[idx];
        int pos = (val / exp) % 10;
        int place = freq[pos];
        res[place-1] = val;
        freq[pos]--;
    }
    
    //coping in original
    for(int i = 0 ; i < arr.length ; i++){
        arr[i] = res[i];
    }
    
    
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}