import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //n : no. of disc
        int src = scn.nextInt(); //src : Source tower
        int dest = scn.nextInt(); //dest : Destination tower
        int helper = scn.nextInt(); // Helper tower
        
        toh(n, src, dest, helper); //Expectation
    }

    public static void toh(int n, int src, int dest, int helper) {
        if(n == 0){
            return;
        }
        
        toh(n - 1, src, helper, dest); //Faith (1)
        System.out.println(n+"["+src+" -> "+dest+"]"); //Faith (2)
        toh(n - 1, helper, dest, src); //Faith (3)

    }

}