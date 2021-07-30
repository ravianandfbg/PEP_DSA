import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
   
   // code starts from here
   public static class BFSPair{
       int vertex;
       String psf;
       BFSPair(int vertex , String psf){
       this.vertex = vertex;
       this.psf = psf;
       }
   }
   public static void BFS(ArrayList<Edge>[] graph , int vertex){
       Queue<BFSPair> queue = new ArrayDeque<>();
       queue.add(new BFSPair(vertex , vertex + ""));
       boolean[] visited = new boolean[graph.length];
       
       while(queue.size() > 0){
           BFSPair pair = queue.remove();
           
           if(!visited[pair.vertex]){
               visited[pair.vertex] = true;
               
               System.out.println(pair.vertex +"@"+ pair.psf);
               
               for(Edge e : graph[pair.vertex]){
                   if(!visited[e.nbr]){
                       queue.add(new BFSPair(e.nbr , pair.psf + e.nbr));
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here 
      BFS(graph , src);
   }
}