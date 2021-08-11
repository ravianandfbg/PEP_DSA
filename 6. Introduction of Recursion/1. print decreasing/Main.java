import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        printDecreasing(n); //Expectation = my work + faith
    }

    public static void printDecreasing(int n) {
        
        if(n == 0){
            return;
        }
        
        System.out.println(n);  //my work
        printDecreasing(n - 1); //Faith

    }

}