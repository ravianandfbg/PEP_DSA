import java.io.*;
import java.util.*;

public class Main {

    //qpsf : queen placed so far
    //tq : total queen
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
            }
            return;
        }
        int nr , nc; //nc : new row , nr : new column
        String seperate = "";
        if(col < tq-1){
            nr = row;
            nc = col+1;
            seperate = "\t";
        }
        else{
            nr = row+1;
            nc = 0;
            seperate = "\n";
        }
        for(int i = 0 ; i < tq ; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutations(qpsf+1 , tq , nr , nc , asf+"q"+(i+1)+seperate , queens); // if i want to place queens
                queens[i] = false;
            }
        }
        queensPermutations(qpsf , tq , nr , nc , asf+"-"+seperate , queens); //if i don't want to place queens
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}