// import java.io.*;
// import java.util.*;

// public class Main{

// public static void main(String[] args) throws Exception {
//     // write your code here
//     Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] arr = new int[n];
        
//         for(int i = 0; i < n; i++){
//             arr[i] = scn.nextInt();
//         }
        
//         //how many subset will create
//         int limit = (int)Math.pow(2 , arr.length);
//         for(int i = 0; i < limit; i++){
//             String set = "";
//             int temp = i;
            
//             for(int j = arr.length - 1; j >= 0; j--){
//                 int rem = temp % 2;
//                 temp = temp / 2;
                
//                 if(rem == 0){
//                     set = "-	" + set;
//                 }
//                 else{
//                     set = arr[j] + "	" + set;
//                 }
//             }
//             System.out.println(set);
//         }
//  }

// }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.io.*;
import java.util.*;

public class main{

public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    
    int n = scn.nextInt();
    int arr[] = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
    }
    
    printSubsets(arr);
 }
 public static void printSubsets(int arr[]){
    int n = arr.length;
    
    int tw = (int)Math.pow(2,n);
    
    for(int num = 0 ; num < tw ; num++){
        int bNum = getBinary(num);
        printSeq(arr,bNum);
    }
 }
 public static void printSeq(int arr[],int bNum){
    int n = arr.length;
    int idx = n-1;
    String str = "";
    while(n != 0){
        int rem = bNum%10;
        bNum = bNum / 10;
        if(rem == 0){
            str = "-\t"+str;
        }else{
            str = arr[idx]+"\t"+str;
        }
        idx--;
        n--;
    }
    System.out.println(str);
 }
 public static int getBinary(int n){
    int rv = 0;
   int pow = 1;
   
   while(n > 0){
       int rem = n%2;
       rv = rv + (rem*pow);
       pow = pow*10;
       n = n / 2;
   }
   
   return rv;
 }

}