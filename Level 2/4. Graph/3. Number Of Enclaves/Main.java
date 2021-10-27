import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

class MAin {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int m = Integer.parseInt(st[0]);
    int n = Integer.parseInt(st[1]);

    int[][] grid = new int[m][n];

    for (int i = 0; i < m; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        grid[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numEnclaves(grid));

  }

  public static int numEnclaves(int[][] grid) {
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                
                // for boundary
                if(i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1 && grid[i][j] == 1){
                    // 1 which is on boundary
                    dfs(grid , i , j);
                }
            }
        }
        
        // count the rest of 1 which can't reach boundary
        int count = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public static void dfs(int[][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return;
        }
        
        grid[i][j] = 0;
        
        dfs(grid , i - 1 , j);
        dfs(grid , i , j - 1);
        dfs(grid , i + 1 , j);
        dfs(grid , i , j + 1);
    }
}