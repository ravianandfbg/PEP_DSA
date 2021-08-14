import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[] arr= new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int data = scn.nextInt();
        
        //FOR FIRST INDEX
        int lo = 0; //lo : Low Index
        int hi = arr.length - 1; //hi : High Index
        int fi = -1; //fi : First Index
        
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(data > arr[mid]){
                lo = mid + 1;
            }
            else if(data < arr[mid]){
                hi = mid - 1;
            }
            else{
                fi = mid;
                hi = mid - 1;
            }
        }
        System.out.println(fi);
        
        
        //FOR LAST INDEX
         lo = 0; //lo : Low Index
         hi = arr.length - 1; //hi : High Index
        int li = -1; //li : Last Index
        
        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(data > arr[mid]){
                lo = mid + 1;
            }
            else if(data < arr[mid]){
                hi = mid - 1;
            }
            else{
                li = mid;
                lo = mid + 1;
            }
        }
        System.out.println(li);
    }

}