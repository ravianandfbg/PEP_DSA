import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        int nr , nc;
        String seperate = "";
        if(col < tq-1){
            nr = row;
            nc = col+1;
            seperate = "";
        }
        else{
            nr = row+1;
            nc = 0;
            seperate = "\n";
        }
        queensCombinations(qpsf+1 , tq , nr , nc , asf+"q"+seperate); //placed
        queensCombinations(qpsf , tq , nr , nc , asf+"-"+seperate); //not placed
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}