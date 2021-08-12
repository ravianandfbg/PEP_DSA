import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int row = scn.nextInt();
        int col = scn.nextInt();
        
        printKnightsTour(new int[n][n] , row , col , 1);
        
    }

    public static void printKnightsTour(int[][] chess, int row, int col, int upcomingMove) {
        // either invalid path or block is already visited
        if(row < 0 || col < 0 || row >= chess.length || col >= chess[0].length || chess[row][col] != 0){
            return;
        }
        
        //positive base case
        if(upcomingMove == chess.length*chess[0].length){
            //here we have visited n*(n-1) move out of n*n
            
            chess[row][col] = upcomingMove; //here we have visited n*n move (which is last) and in this case it is 25
            
            displayBoard(chess);
            chess[row][col] = 0; //unmarked
            return;
            
        }
        
        
        chess[row][col] = upcomingMove; //marked
        
        printKnightsTour(chess , row-2 , col+1 , upcomingMove+1); //dir 1
        printKnightsTour(chess , row-1 , col+2 , upcomingMove+1); // dir 2
        printKnightsTour(chess , row+1 , col+2 , upcomingMove+1); // dir 3
        printKnightsTour(chess , row+2 , col+1 , upcomingMove+1); //dir 4
        printKnightsTour(chess , row+2 , col-1 , upcomingMove+1); //dir 5
        printKnightsTour(chess , row+1 , col-2 , upcomingMove+1); //dir 6
        printKnightsTour(chess , row-1 , col-2 , upcomingMove+1); //dir 7
        printKnightsTour(chess , row-2 , col-1 , upcomingMove+1); //dir 8
        
        
        chess[row][col] = 0; //unmarked
        
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