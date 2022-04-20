import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int nr = scn.nextInt();
        int nc = scn.nextInt();
        int[][] mat = new int[nr][nc];
        
        for(int i = 0; i < nr; i++){
            for(int j = 0; j < nc; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        ExitPoint(mat);
    }
    
    
    public static void ExitPoint(int[][] mat){
        int nr = mat.length;
        int nc = mat[0].length;
        
        int dir = 0; // assume 0->East , 1 -> South , 2 -> West , 3 -> North
        int i = 0 , j = 0; //Entry point : (0,0)
        
        while(true){
            dir = (dir + mat[i][j]) % 4;
            
            //here i = x , j = y
            if(dir == 0){
                j++; // we will move in East direction (x,y+1) , here y increase
            }
            else if(dir == 1){
                i++; // we will move in South direction (x+1,y) , here x increase
            }
            else if(dir == 2){
                j--; // we will move in West direction (x,y-1) , here y decreases
            }
            else if(dir == 3){
                i--; // we will move in North direction (x-1,y) , here x decreases
            }
            
            if(nc == j){
                //exited through right wall using east direction
                j = nc-1;
                break;
            }
            else if(nr == i){
                //exited through bottom wall using South direction
                i = nr-1;
                break;
            }
            else if(j < 0){
                //exited through left wall using West direction
                j = 0;
                break;
            }
            else if(i < 0){
                //exited through up wall using North direction
                i = 0;
                break;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }

}