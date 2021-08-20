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
   public static class InfectedPair{
       int vertices , toi; // toi : time of infection
       InfectedPair(int vertices , int toi){
           this.vertices = vertices;
           this.toi = toi;
       }
   }
   
   public static void spreadOfInfection(ArrayList<Edge>[] graph , int src  ,  int rt){ //rt : response time
   
       Queue<InfectedPair> queue = new ArrayDeque<>();
       
       queue.add(new InfectedPair(src , 1));
       boolean[] visited = new boolean[graph.length];
       int count = 0;
       
       while(queue.size() > 0){
           InfectedPair Pair = queue.remove();
           if(!visited[Pair.vertices]){
               visited[Pair.vertices] = true;
               
               if(Pair.toi <= rt){
                   count++;
               }
               for(Edge e : graph[Pair.vertices]){
                   if(!visited[e.nbr]){
                       queue.add(new InfectedPair(e.nbr , Pair.toi + 1));
                   }
               }
           }
       }
       System.out.println(count);
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
      int t = Integer.parseInt(br.readLine());
      
      // write your code here
      spreadOfInfection(graph , src  , t);
   }

}





