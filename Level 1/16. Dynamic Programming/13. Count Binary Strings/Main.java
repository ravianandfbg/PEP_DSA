import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //oSEW0 :- Old String Ending With 0
    //oSEW1 :- Old String Ending With 1
    int oSEW0 = 1 , oSEW1 = 1;
    
    for(int i = 2 ; i <= n ; i++){
        //nSEW0 :- New String Ending With 0
        int nSEW0 = oSEW1;
        
        //nSEW1 :- new String Ending With 1
        int nSEW1 = oSEW0 + oSEW1;
        
        oSEW0 = nSEW0;
        oSEW1 = nSEW1;
    }
    
    System.out.println(oSEW0 + oSEW1);
    
 }

}