import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        System.out.println(getStairPaths(n));

    }

    public static ArrayList < String > getStairPaths(int n) {
        if (n == 0) {
            ArrayList < String > bl = new ArrayList < > ();
            bl.add("");
            return bl;
        } else if (n < 0) {
            ArrayList < String > bl = new ArrayList < > ();
            return bl;
        }

        ArrayList < String > paths1 = getStairPaths(n - 1);
        ArrayList < String > paths2 = getStairPaths(n - 2);
        ArrayList < String > paths3 = getStairPaths(n - 3);

        ArrayList < String > myPath = new ArrayList < > ();

        for (String s: paths1) {
            myPath.add(1 + s);
        }

        for (String s: paths2) {
            myPath.add(2 + s);
        }

        for (String s: paths3) {
            myPath.add(3 + s);
        }
        return myPath;
    }
}