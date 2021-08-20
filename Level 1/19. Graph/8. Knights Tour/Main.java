import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int row = scn.nextInt();
        int col = scn.nextInt();
        
        printKnightsTour(new int[n][n], row, col, 1);
        
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int moveNo) {
        if(row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col]!= 0){
            //either invalid position or block is already visited
            return;
        }
        
        if(moveNo == chess.length * chess[0].length){ //here we have visited n * n-1 move out of n * n
            chess[row][col] = moveNo; //here we have visited n*n move(which is last; i.e 25)
            displayBoard(chess);
            chess[row][col] = 0;
            return;
        }
        
        chess[row][col] = moveNo; //mark
        
        printKnightsTour(chess, row-2, col+1, moveNo+1); //dir
        printKnightsTour(chess, row-1, col+2, moveNo+1); //dir2
        printKnightsTour(chess, row+1, col+2, moveNo+1); //dir3
        printKnightsTour(chess, row+2, col+1, moveNo+1); //dir4
        printKnightsTour(chess, row+2, col-1, moveNo+1); //dir5
        printKnightsTour(chess, row+1, col-2, moveNo+1); //dir6
        printKnightsTour(chess, row-1, col-2, moveNo+1); //dir7
        printKnightsTour(chess, row-2, col-1, moveNo+1); //dir8
        
        chess[row][col] = 0; //unmark
        
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}