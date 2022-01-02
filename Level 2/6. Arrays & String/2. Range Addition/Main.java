import java.util.*;
 
 public class Main {
 
     // This is a functional problem. You have to complete this function.
     // It takes as input a length and a 2D array of update operations.
     // It should return the modified array.
     public static int[] Range(int length, int[][] updates) {
         // write your code here. 
         int[] arr = new int[length];
         
         for(int k = 0 ; k < updates.length ; k++){
             int si = updates[k][0]; // si : starting index
             int ei = updates[k][1]; // ei : ending index
             int inc = updates[k][2]; // inc : increment
             
             arr[si] += inc;
             
             if(ei + 1 < arr.length){
                 arr[ei + 1] += -inc;
             }
             
         }
         int[] psa = new int[arr.length]; // psa : prefix sum array
         psa[0] = arr[0];
         
         for(int i = 1 ; i < arr.length ; i++){
             psa[i] = psa[i - 1] + arr[i];
         }
         return psa;
         
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Input for length of first array.
         int length = sc.nextInt();
 
         int K = sc.nextInt();
 
         int[][] updates = new int[K][3];
 
         for (int i = 0; i < updates.length; i++) {
             for (int j = 0; j < updates[0].length; j++) {
                 updates[i][j] = sc.nextInt();
             }
         }
 
         int[] result = Range(length, updates);
         display(result);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 
 }