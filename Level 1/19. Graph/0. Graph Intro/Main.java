import java.io.*;
import java.util.*;

public class Main{

      public static class Edge{
            int src , nbr , wt; // nbr : nebighour
            Edge(int src , int nbr , int wt){
                  this.src = src;
                  this.nbr = nbr;
                  this.wt = wt;

            }
      }

      public static void display(ArrayList<Edge>[] graph){
            int vertices = graph.length;

            for(int i = 0 ; i < vertices ; i++){
                  ArrayList<Edge> list = graph[i];
                  System.out.print(i+" -> ");
                  for(Edge e : list){
                        System.out.print(e.nbr+" ");
                  }
                  System.out.println();
            }
      }
      public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);

            int vertices = scn.nextInt();
            int edges = scn.nextInt();

            ArrayList<Edge>[] graph = new ArrayList[vertices];

            for(int i = 0 ; i  < vertices ; i++){
                  graph[i] = new ArrayList<Edge>();

            }
            for(int i = 0 ; i < edges ; i++){
                  int v1 = scn.nextInt();
                  int v2 = scn.nextInt();
                  int wt = scn.nextInt();

                  graph[v1].add(new Edge(v1,v2,wt));
                  graph[v2].add(new Edge(v2,v1,wt));
            }

            display(graph);
      }
}

/*
INPUT :-

7
8
0 3 40
0 1 10
1 2 10
2 3 10
3 4 4
4 5 3
5 6 3
4 6 8
*/
