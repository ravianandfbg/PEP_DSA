import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)  {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        System.out.println(getMazePaths(0, 0, nr - 1, nc - 1));
    }

    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr > dr || sc > dc) {
            return new ArrayList < > ();
        }

        if (sr == dr && sc == dc) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        ArrayList < String > myList = new ArrayList < > ();
        
        //FOR HORIZONTAL PATH
        for (int jump = 1; sc + jump <= dc; jump++) {
            ArrayList < String > hpaths = getMazePaths(sr, sc + jump, dr, dc); //hpaths : horizontal paths
            for (String path: hpaths) {
                myList.add("h" + jump + path);
            }
        }
        
        
        //FOR VERTICAL PATH
        for (int jump = 1; sr + jump <= dr; jump++) {
            ArrayList < String > vpaths = getMazePaths(sr + jump, sc, dr, dc); //vpaths : vertical paths
            for (String path: vpaths) {
                myList.add("v" + jump + path);
            }
        }
        
        
        //FOR DIAGONAL PATH
        for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
            ArrayList < String > dpaths = getMazePaths(sr + jump, sc + jump, dr, dc); //dpaths : diagonal paths
            for (String path: dpaths) {
                myList.add("d" + jump + path);
            }
        }

        return myList;
    }
}