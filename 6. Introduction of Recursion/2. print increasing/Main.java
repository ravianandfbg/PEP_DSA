import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // 5

        printIncreasing(n); //Expectation
    }

    public static void printIncreasing(int n) {

        if (n == 0) {
            return;
        }
        printIncreasing(n - 1); //Faith
        System.out.println(n); //my work

    }

}