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
   public static int countVisited(boolean[] visited){
       int count = 0;
       for(boolean res : visited){
           if(res){
               count++;
           }
       }
       return count;
   }
   public static void hamiltonian(ArrayList<Edge>[] graph , int vertices , String psf , boolean[] visited , int vsf , int oSrc){ // vsf : visited so far , //oSrc : original source
       visited[vertices] = true;
       
       if(vsf == graph.length){
           
           boolean directEdge= false;
           for(Edge e : graph[vertices]){
               if(e.nbr == oSrc){
                   directEdge = true;
                   break;
               }
           }
           if(directEdge){
               // hamiltonian cycle
               System.out.println(psf+"*");
           }
           else{
               // hamiltonian path
                 System.out.println(psf+".");
           }
       }
       for(Edge e : graph[vertices]){
           if(!visited[e.nbr]){
               hamiltonian(graph , e.nbr , psf+e.nbr , visited , vsf+1 , oSrc);
           }
       }
       visited[vertices] = false;
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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      hamiltonian(graph , src , ""+src , new boolean[vtces] , 1 , src);
   }


}