import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        floodfill(arr, 0, 0, "" , new boolean[n][m]);
    }
    
    // asf -> answer so far
    public static void floodfill(int[][] maze, int row, int col, String asf , boolean[][] visited) {
        
        //invalid path
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == 1 || visited[row][col] == true){
            return;
        }
        
        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(asf);
            return;
        }
        
        visited[row][col] = true;
        
        // for top
        floodfill(maze , row-1 , col , asf + 't' , visited); 
        
        //for left
        floodfill(maze , row , col-1 , asf + 'l' , visited);
        
        //for down
        floodfill(maze , row+1 , col , asf + 'd' , visited);
        
        //for right
        floodfill(maze , row , col+1 , asf + 'r' , visited);
        
        visited[row][col] = false;
        
    
    }
}