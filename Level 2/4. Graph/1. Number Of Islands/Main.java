import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
   System.out.println(numOfIslands(arr));

}

public static int numOfIslands(int board[][]){
    int count = 0;
    for(int i = 0 ; i < board.length ; i++){
        for(int j = 0 ; j < board[0].length ; j++){
           if(board[i][j] == 0){
               count++;
               numOfIslandsHelper(board , i , j); //mark whole island
           }
        }
    }
    return count;
}

public static void numOfIslandsHelper(int board[][] , int row , int column){
    if(row < 0 || column < 0 || row >= board.length || column >= board[0].length || board[row][column] == 1 || board[row][column] == 2){
        return;
    }
    
    board[row][column] = 2; // visited
    
    numOfIslandsHelper(board , row-1 , column); // north
    numOfIslandsHelper(board , row , column-1); //east
    numOfIslandsHelper(board , row , column+1); //west
    numOfIslandsHelper(board , row+1 , column); //south
} 
}