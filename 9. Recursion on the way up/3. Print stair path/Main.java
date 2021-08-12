import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        printStairPaths(n,"");

    }
    //psf : path so far
    public static void printStairPaths(int n, String psf) {
        if(n < 0){
            return;
        }
        if(n == 0){
            System.out.println(psf);
            return;
        }
        printStairPaths(n-1,psf+"1");
        printStairPaths(n-2,psf+"2");
        printStairPaths(n-3,psf+"3");
    }

}