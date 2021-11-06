import java.io.*;
import java.util.*;


public class Main{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
        
		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
	
	
	// code starts from here
	
	public static void dfs(int src , ArrayList<ArrayList<Integer>> graph , boolean[] vis , Stack<Integer> st){
        vis[src] = true;
        
        for(int nbr : graph.get(src)){
            if(vis[nbr] == false){
                dfs(nbr , graph , vis, st);
            }
        }
        st.push(src);
    }
    
    public static void dfs(int src , ArrayList<ArrayList<Integer>> graph , boolean[] vis){
        vis[src] = true;
        
        for(int nbr : graph.get(src)){
            if(vis[nbr] == false){
                dfs(nbr , graph , vis);
            }
        }
    }
    
    public static int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // 1. perform DFS and fill the stack in post-order
        boolean[] vis = new boolean[adj.size()];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0 ; i < adj.size() ; i++){
            if(vis[i] == false){
                dfs(i,adj,vis,st);
            }
        }
        
        // 2. check if potential mother vertex is a mother vertex
        vis = new boolean[adj.size()];
        
        dfs(st.peek(),adj,vis);
        
        for(int i = 0 ; i < adj.size() ; i++){
            if(vis[i] == false){
                return -1;
            }
        }
        return st.peek()+1;
    }
}