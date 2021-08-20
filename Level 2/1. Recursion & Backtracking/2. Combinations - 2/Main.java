import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
    // write your code here
    if(ci > ti){
    for(int vl : boxes){
        System.out.print(vl != 0 ? "i":"-");
    }
    System.out.println();
    return;
    }
    for(int bi = lb +1 ; bi < boxes.length ; bi++){
        boxes[bi] = 1;
        combinations(boxes , ci+1 , ti , bi);
        boxes[bi] = 0;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, -1);
  }

}