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
   public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge>[] graph){
       boolean visited[] = new boolean[graph.length];
       ArrayList<ArrayList<Integer>> allComps = new ArrayList<>();
       
       for(int vertex = 0 ; vertex < graph.length ; vertex++){
           if(!visited[vertex]){
               //it means if visited[vertex] = false then it will converted into true
               ArrayList<Integer> comp = new ArrayList<>();
               gccHelper(graph , vertex , comp , visited);
               
               allComps.add(comp);
           }
       }
       return allComps;
   }
   public static void gccHelper(ArrayList<Edge>[] graph , int vertices , ArrayList<Integer> comp , boolean[] visited){
       visited[vertices] = true;
       comp.add(vertices);
       
       for(Edge e : graph[vertices]){
           if(!visited[e.nbr]){
               gccHelper(graph , e.nbr , comp , visited);
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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      comps = gcc(graph);

      System.out.println(comps);
   }
}