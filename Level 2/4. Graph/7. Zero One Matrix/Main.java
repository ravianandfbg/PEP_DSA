import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  private static class Pair {
    int i;
    int j;

    Pair(int i, int j) {
      this.i = i;
      this.j = j;
    }
  }

  private static int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

    int[][] ans = updateMatrix(arr);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

  }

 // code starts from here
 
  public static int[][] updateMatrix(int[][] mat) {
      int n = mat.length;
        int m = mat[0].length;
        
        int[][] dist = new int[n][m];
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j));
                }
            }
        }
        
        int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}}; // {{top},{left},{down},{right}} 
        
        // BFS
        
        while(q.size() > 0){
            Pair rem = q.remove();
            
            for(int k = 0 ; k < 4 ; k++){
                int ni = rem.i + dir[k][0];
                int nj = rem.j + dir[k][1];
                
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1){
                    dist[ni][nj] = dist[rem.i][rem.j] + 1;
                    q.add(new Pair(ni,nj));
                    
                    mat[ni][nj] = -1; // mark visited
                }
            }
        }
        return dist;

  }
}