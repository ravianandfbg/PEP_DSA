import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    int n = Integer.parseInt(st[0]);
    int m = Integer.parseInt(st[1]);

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(numDistinctIslands(arr));

  }

  public static StringBuilder psf = new StringBuilder();

  // code starts from here
  
  static String comp;
  public static int numDistinctIslands(int[][] grid) {
   HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    comp = "";
                    dfs(grid , i , j);
                    set.add(comp);
                }
            }
        }
        return set.size();
    }

    public static void dfs(int[][] grid , int i , int j){
        grid[i][j] = 0;

        //top
        if(i - 1 >= 0 && grid[i-1][j] == 1){
            comp += 't';
            dfs(grid , i - 1, j);
        }

        // left
        if(j - 1 >= 0 && grid[i][j-1] == 1){
            comp += 'l';
            dfs(grid , i , j - 1);
        }

        // down
        if(i + 1 < grid.length && grid[i+1][j] == 1){
            comp += 'd';
            dfs(grid, i + 1, j);
        }

        // right
        if(j + 1 < grid[0].length && grid[i][j+1] == 1){
            comp += 'r';
            dfs(grid, i, j + 1);
        }

        // backtracking
        comp += 'z';
    }
}