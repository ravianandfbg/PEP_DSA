import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        System.out.println(getMazePaths(0, 0, nr - 1, nc - 1));

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr > dr || sc > dc){
            //Invalid case
            return new ArrayList < String > ();
        }
        
        if(sr == dr && sc == dc){
            //Best case
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }
        ArrayList < String > hPaths = getMazePaths(sr, sc + 1, dr, dc); //hPaths : Horizontal Paths
        ArrayList < String > vPaths = getMazePaths(sr + 1, sc, dr, dc); //vPaths : Vertical Paths
        
        ArrayList < String > myList = new ArrayList < > ();
        
        for(String path : hPaths){
            myList.add("h" + path);
        }
        for(String path : vPaths){
            myList.add("v" + path);
        }
        return myList;
    }

}