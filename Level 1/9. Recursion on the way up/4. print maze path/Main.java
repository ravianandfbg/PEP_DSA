import java.io.*;
	import java.util.*;

	public class Main {

	    public static void main(String[] args) {
	        Scanner scn = new Scanner(System.in);
	        int nr = scn.nextInt();
	        int nc = scn.nextInt();
	        
	        printMazePaths(0, 0, nr-1, nc-1, "");

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
	        printMazePaths(sr, sc+1, dr, dc, psf+"h");
	        printMazePaths(sr+1, sc, dr, dc, psf+"v");
	        
	    }

	}