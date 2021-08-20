import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ; i < n ; i++){
        arr[i] = scn.nextInt();
    }
    
    HashMap<Integer , Boolean> hm = new HashMap<>();
    for(int val : arr){
        hm.put(val , true);
    }
    
    for(int val : arr){
        if(hm.containsKey(val-1)){
            hm.put(val , false);
        }
    }
    int oSp = 0; // oSp : overall Starting point (we can initalize anything in oSp)
    int oCounter = 0; //oCounter : overall counter
    
    for(int val : arr){
        if(hm.get(val) == true){
            int sp = val;
            int counter = 1;
            
            while(hm.containsKey(sp + counter)){
                counter++;
            }
            if(counter > oCounter){
                oCounter = counter;
                oSp = sp;
            }
        }
    }
    for(int i = 0 ; i < oCounter ; i++){
        System.out.println(oSp + i);
    }
 }

}