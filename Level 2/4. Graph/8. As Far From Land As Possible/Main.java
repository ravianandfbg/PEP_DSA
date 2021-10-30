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

    System.out.println(maxDistance(arr));

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

  public static int maxDistance(int[][] grid) {
      int n = grid.length;
        int m = grid[0].length;
        
        int[][] dist = new int[n][m];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j));
                }
            }
        }
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}}; // {{top},{left},{down},{right}} 
        
        int max_dist = -1;
        
        // BFS
        while(q.size() > 0){
            Pair rem = q.remove();
            
            
            for(int k = 0 ; k < 4 ; k++){
                int ni = rem.i + dir[k][0]; // ni : neighbour of i
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni][nj] == 0){
                    dist[ni][nj] = dist[rem.i][rem.j] + 1;
                    q.add(new Pair(ni,nj));
                     max_dist = Math.max(dist[ni][nj],max_dist);
                    
                    grid[ni][nj] = -1; // mark visited
                }
            }
        }
        return max_dist;

  }
}
