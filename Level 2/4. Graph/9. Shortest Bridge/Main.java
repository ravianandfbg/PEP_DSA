import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    System.out.println(shortestBridge(arr));

  }
  
  
  // code starts from here
  
  public static class Pair{
        int i;
        int j;
        
        Pair(){
            
        }
        Pair(int i , int j){
            this.i = i;
            this.j = j;
        }
    }

  public static int shortestBridge(int[][] grid) {
              ArrayDeque<Pair> q = new ArrayDeque<>();
        
        boolean flag = true;
        for(int i = 0 ; i < grid.length && flag == true; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,q);
                    flag = false;
                    break;
                }
            }
        }
        
         
        int lev = 0;
        
        // levelorder BFS
        while(q.size() > 0){
            int count = q.size();
            
            for(int i = 0 ; i < count ; i++){
                // remove
                Pair rem = q.remove();
                
                // add unvisited nbr
                for(int k = 0 ; k < 4 ; k++){
                    int ni = rem.i + dir[k][0];
                    int nj = rem.j + dir[k][1];
                    
                    if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length){
                        if(grid[ni][nj] == 1){
                            return lev;
                        }
                        else if(grid[ni][nj] == 0){
                            q.add(new Pair(ni,nj));
                            
                            grid[ni][nj] = -1; // marked visited
                        }
                    }
                    
                }
            }
            lev++;
        }
        return -1;
    }
    
    static int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}}; // {{top},{left},{down},{right}}
    public static void dfs(int[][] grid , int i , int j , ArrayDeque<Pair> q){
        q.add(new Pair(i,j));
         grid[i][j] = -1; // marked visited
        for(int k = 0 ; k < 4 ; k++){
                    int ni = i + dir[k][0];
                    int nj = j + dir[k][1];
            
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1){
                dfs(grid,ni,nj,q);
            }
            
        }
    }
}
