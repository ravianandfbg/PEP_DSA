import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());

    int[][] arr = new int[n][m];

    for (int i = 0; i < n; i++) {
      String[] st = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        arr[i][j] = Integer.parseInt(st[j]);
      }
    }

    String[] st1 = br.readLine().split(" ");
    int src = Integer.parseInt(st1[0]);
    int dest = Integer.parseInt(st1[1]);
    System.out.println(numBusesToDestination(arr, src, dest));

  }

 // code starts from here
 
  public static int numBusesToDestination(int[][] routes, int S, int T) {
      HashMap<Integer,ArrayList<Integer>> map = new HashMap<>(); // bus stand vs buses
        
        for(int i = 0 ; i < routes.length ; i++){
            for(int j = 0 ; j < routes[i].length ; j++){
                int bus_no = i;
                int bus_stand_no = routes[i][j];
                
                if(map.containsKey(bus_stand_no) == false){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(bus_no);
                    map.put(bus_stand_no , list);
                }
                else{
                    ArrayList<Integer> list = map.get(bus_stand_no);
                    list.add(bus_no);
                    map.put(bus_stand_no , list);
                }
            }
        }
        return bfs(routes,S,T,map);
    }
    
    public static class Pair{
        int bus_stand_no;
        int level;
        
        Pair(){
            
        }
        Pair(int bus_stand_no , int level){
            this.bus_stand_no = bus_stand_no;
            this.level = level;
        }
    }
    
    public static int bfs(int[][] routes, int src , int dest , HashMap<Integer,ArrayList<Integer>> map){
        // map -> bus_stand_no vs buses
        
        HashSet<Integer> bus_stand_no_visited = new HashSet<>(); // bus satnd visited
        HashSet<Integer> bus_visited = new HashSet<>(); // bus visited
        
        ArrayDeque<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair(src,0));
        bus_stand_no_visited.add(src); // mark on addition
        
        while(q.size() > 0){
            // remove
            Pair rem = q.remove();
            
            // work
            if(rem.bus_stand_no == dest){
                return rem.level;
            }
            
             // add unvisited nbr
            ArrayList<Integer> buses = map.get(rem.bus_stand_no);
            
            for(int bus : buses){
                if(bus_visited.contains(bus) == false){
                    bus_visited.add(bus);
                    
                    // travel all the unvisited bus_stand_no of this bus
                    for(int bus_stop : routes[bus]){
                        if(bus_stand_no_visited.contains(bus_stop) == false){
                            q.add(new Pair(bus_stop , rem.level+1));
                            bus_stand_no_visited.add(bus_stop);
                        }
                    }
                }
            }
            
        }
        return -1;
    }
}
