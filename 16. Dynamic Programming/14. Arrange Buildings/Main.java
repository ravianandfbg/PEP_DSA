import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    // let s = 1 , B = 0
    //oSEWB :- Old String Ending With B
    //oSEWS :- Old String Ending With S
    long oSEWB = 1 , oSEWS = 1;
    
    for(int i = 2 ; i <= n ; i++){
        //nSEWB :- New String Ending With B
        long nSEWB = oSEWS;
        
        //nSEWS :- new String Ending With S
        long nSEWS = oSEWB + oSEWS;
        
        oSEWB = nSEWB;
        oSEWS = nSEWS;
    }
    long oneside = oSEWB + oSEWS;
    
    System.out.println(oneside * oneside);
    
 }

}