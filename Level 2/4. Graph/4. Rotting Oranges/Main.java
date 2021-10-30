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

    System.out.println(orangesRotting(arr));

  }

  public static class Pair {
    int i;
    int j;
    int time;
    
    Pair(){
        
    }
    Pair(int i, int j, int time) {
      this.i = i;
      this.j = j;
      this.time = time;
    }
  }

  public static int orangesRotting(int[][] grid) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        int fo = 0; // fo : fresh Orange
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2){
                    // this orange already rotten
                    q.add(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1){
                    fo++;
                }
            }
    }
    
    
    int[][] dir = {{-1,0}, {0,-1}, {1,0}, {0,1}}; // {{top},{left},{down},{right}}
        
    // BFS
    int ans = 0;
    while(q.size() > 0){
        
        // remove
        Pair rem = q.remove();
        
        ans = rem.time; // because we have to return the last time
        
        // add unvisited nbr
        for(int k = 0 ; k < 4 ; k++){
            int ni = rem.i + dir[k][0];
            int nj = rem.j + dir[k][1];
            
            if(ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1){
                q.add(new Pair(ni , nj , rem.time + 1));
                grid[ni][nj] = 2; // marking on addition
                
                fo--;
            }
        }
    }
    // if fo = 0 then it will return the last time which is stored in ans variable otherwise if any 1 will remain then it will return -1
    return fo == 0 ? ans : -1; 
  }
}