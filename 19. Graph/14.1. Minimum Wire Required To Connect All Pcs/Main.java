import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   //code start from here
   public static class Pair implements Comparable<Pair>{
       int current_vertex , parent_vertex , wt;
       Pair(int current_vertex , int parent_vertex , int wt){
           this.current_vertex = current_vertex;
           this.parent_vertex = parent_vertex;
           this.wt = wt;
       }
       public int compareTo(Pair o){
           return this.wt - o.wt; //priority queue on the basis of cost
       }
   }
   
   public static void mst(ArrayList<Edge>[] graph){
       PriorityQueue<Pair> pq = new PriorityQueue<>();
       boolean visited[] = new boolean[graph.length];
       pq.add(new Pair(0 , -1 , 0));
       
       while(pq.size() > 0){
           Pair tmp = pq.remove();
           if(visited[tmp.current_vertex] == false){
               visited[tmp.current_vertex] = true;
               
               if(tmp.parent_vertex != -1){
                   System.out.println("["+tmp.current_vertex+"-"+tmp.parent_vertex+"@"+tmp.wt+"]");
               }
               
               for(Edge e : graph[tmp.current_vertex]){
                   if(visited[e.nbr] == false){
                       pq.add(new Pair(e.nbr , tmp.current_vertex , e.wt));
                   }
               }
           }
       }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      mst(graph);
   }

}