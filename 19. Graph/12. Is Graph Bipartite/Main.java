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
   
   
   // code starts from here
   public static class isBipartitlePair{
       int vertex;
       int level;
       isBipartitlePair(int vertex , int level){
           this.vertex = vertex;
           this.level = level;
       }
   }
   public static boolean isBipartitle(ArrayList<Edge>[] graph){
       int[] visited = new int[graph.length];
       Arrays.fill(visited , -1);
       for(int vertex = 0 ; vertex < graph.length ; vertex++){
           if(visited[vertex] == -1){
               boolean res = isBipartitleHelper(graph , vertex , visited);
               if(!res){
                   return false;
               }
           }
       }
       return true;
   }
   
   public static boolean isBipartitleHelper(ArrayList<Edge>[] graph , int vertex , int[] visited){
       Queue<isBipartitlePair> queue = new ArrayDeque<>();
       queue.add(new isBipartitlePair(vertex , 0));
       
       while(queue.size() > 0){
           isBipartitlePair pair = queue.remove();
           
           if(visited[pair.vertex] == -1){
               visited[pair.vertex] = pair.level;
               
               for(Edge e : graph[pair.vertex]){
                   if(visited[e.nbr] == -1){
                       queue.add(new isBipartitlePair(e.nbr , pair.level + 1));
                   }
               }
                   }
               else{
                   if(pair.level != visited[pair.vertex]){
                       return false;
               }
               
           }
       }
           return true;
       
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
      System.out.println(isBipartitle(graph));
   }
}