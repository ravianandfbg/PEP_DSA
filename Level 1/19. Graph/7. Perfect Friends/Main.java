import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       
       int vertices = scn.nextInt();
       int edges = scn.nextInt();
       
       ArrayList<Edge>[] graph = new ArrayList[vertices];
       
       for(int i = 0; i < vertices ; i++){
           graph[i] = new ArrayList<Edge>();
       }
       
       for(int i = 0 ; i < edges; i++){
           int v1 = scn.nextInt();
           int v2 = scn.nextInt();
           int wt = 0;
           
           graph[v1].add(new Edge(v1 , v2 , wt));
           graph[v2].add(new Edge(v2 , v1 , wt));
       }
       
       System.out.println(perfectFriends(graph));
       
    }
    
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
   public static int perfectFriends(ArrayList<Edge>[] graph){
       ArrayList<ArrayList<Integer>> allComps = gcc(graph);
       int ways = 0;
       for(int i = 0 ; i < allComps.size() ; i++){
           for(int j = i+1 ; j < allComps.size() ; j++){
               ways += (allComps.get(i).size() * allComps.get(j).size());
           }
       }
       return ways;
   }

}