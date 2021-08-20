import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
    // write your code here
    if(ci > ti){
        for(int vl : boxes){
            System.out.print(vl);
        }
        System.out.println();
        return;
    }
    for(int bi = 0 ; bi < boxes.length ; bi++){ //bi : box index
        if(boxes[bi] == 0){ //empty box
            boxes[bi] = ci; //object placed
            permutations(boxes,ci+1,ti);
            boxes[bi] = 0; // object unplaced
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}