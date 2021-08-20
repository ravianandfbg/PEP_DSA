import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        
        printMazePaths(0,0,nr-1,nc-1,"");

    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr > dr || sc > dc){
            return;
        }
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        
        //for horizontal path
        for(int jump = 1; sc+jump <= dc; jump++){
            printMazePaths(sr, sc+jump, dr, dc, psf+"h"+jump);
        }
        
        //for vertical
        for(int jump = 1; sr+jump <= dr; jump++){
            printMazePaths(sr+jump, sc, dr, dc, psf+"v"+jump);
        }
        //for diagonal
        for(int jump = 1; sr+jump <= dr && sc+jump <= dc; jump++){
        printMazePaths(sr+jump,sc+jump,dr,dc,psf+"d"+jump);
        }
    }
    
}