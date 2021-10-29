import java.io.*;
import java.util.*;

public class Main {
  static class Edge implements Comparable<Edge> {
    int vertex;
    int wt;

    Edge(int nbr, int wt) {
      this.vertex = nbr;
      this.wt = wt;
    }

    @Override
    public int compareTo(Edge o) {
      return this.wt - o.wt;
    }
  }
 
  // code starts from here
  public static int minCost(ArrayList<ArrayList<Edge>> graph){
      int cost = 0;
      PriorityQueue<Edge> pq = new PriorityQueue<>();
      
      pq.add(new Edge(0,0));
      boolean[] visited = new boolean[graph.size()];
      
      while(pq.size() > 0){
          // remove
          Edge rem = pq.remove();
          
          // mark*
          if(visited[rem.vertex] == true){
              continue;
          }
          visited[rem.vertex] = true;
          
          // work
          cost += rem.wt; 
          
          // add unvisited nbr
          for(Edge edge : graph.get(rem.vertex)){
              int nbr = edge.vertex;
              int wt = edge.wt;
              
              if(visited[nbr] == false){
                  pq.add(new Edge(nbr,wt));
              }
          }
      }
      return cost;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int vtces = Integer.parseInt(br.readLine());
    ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    for (int i = 0; i < vtces; i++) {
      graph.add(new ArrayList<>());
    }

    int edges = Integer.parseInt(br.readLine());
    for (int i = 0; i < edges; i++) {
      String[] parts = br.readLine().split(" ");
      int v1 = Integer.parseInt(parts[0]);
      int v2 = Integer.parseInt(parts[1]);
      int wt = Integer.parseInt(parts[2]);
      graph.get(v1).add(new Edge(v2, wt));
      graph.get(v2).add(new Edge(v1, wt));
    }
System.out.println(minCost(graph));
  }

}
