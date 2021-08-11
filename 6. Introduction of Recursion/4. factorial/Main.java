import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int nFact = factorial(n);
        System.out.println(nFact);
        
    }

    public static int factorial(int n) {
        
        if(n == 1){
            return 1;
        }
        int nM1Fact = factorial(n - 1); //nM1Fact = n minus 1 factorial
        int nFact = n * nM1Fact;
        return nFact;
    }

}