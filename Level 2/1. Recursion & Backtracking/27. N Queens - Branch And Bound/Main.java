import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        printNQueens(new int[n][n] , "" , 0 , new int[n] , new int[2*n-1] , new int[2*n-1]);
        
    }

    public static void printNQueens(int[][] chess, String qsf , int row , int bcol[] , int bld[] , int brd[]) {
        // bcol : block column
        // bld : block left diagonal
        // brd : block right diagonal
        
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }
        for(int col = 0 ; col < chess.length ; col++){
            if(isQueenSafe(chess , row , col , bcol , bld , brd)){
                chess[row][col] = 1;
                
                //mark
                bcol[col] = 1;
                bld[row - col + chess.length - 1] = 1;
                brd[row + col] = 1;
                
                printNQueens(chess , qsf + row + "-" + col + ", " , row + 1 , bcol , bld , brd);
                
                // unmark
                bcol[col] = 0;
                bld[row - col + chess.length - 1] = 0;
                brd[row + col] = 0;
                
                chess[row][col] = 0;
            }
        }
    }
        
        public static boolean isQueenSafe(int[][] chess, int i , int j , int bcol[] , int bld[] , int brd[]){
            
        
        // for column
        if(bcol[j] == 1){
            return false; // unsafe
        }
        
        //for left diagonal
        if(bld[i - j + chess.length - 1] == 1){
            return false; // unsafe
        }
        
        //for right diagonal
        if(brd[i + j] == 1){
            return false; // unsafe
        }
        return true;
        }
        
    }