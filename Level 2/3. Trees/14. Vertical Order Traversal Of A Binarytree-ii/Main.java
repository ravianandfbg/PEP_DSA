import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    // code starts from here
     public static class Pair implements Comparable<Pair>{
        TreeNode node;
        int x;
        int y;
        
        Pair(){
            
        }
        Pair(TreeNode node , int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
        
        // this < o -> -ve
        // this > o -> +ye
        // this = o -> 0
        
        public int compareTo(Pair o){
            if(this.y != o.y){
                return this.y - o.y;
            }
            else if(this.x != o.x){
                return this.x - o.x;
            }
            else{
                return this.node.val - o.node.val;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<Integer>>map = new HashMap<>();
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(root , 0 , 0));
        
        int min = Integer.MAX_VALUE; // min vertical line number
        int max = Integer.MIN_VALUE; // max vertical line number
        
        while(pq.size() > 0){
            Pair rem = pq.remove();
            TreeNode node = rem.node;
            int x = rem.x;
            int y = rem.y;
            
            min = Math.min(min , x);
            max = Math.max(max , x);
            
            if(map.containsKey(x) == false){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.val);
                map.put(x , list);
            }
            else{
                ArrayList<Integer> list = map.get(x);
                list.add(node.val);
                map.put(x , list);
            }
            
            if(node.left != null){
                pq.add(new Pair(node.left , x-1 , y+1));
            }
            if(node.right != null){
                pq.add(new Pair(node.right , x+1 , y+1));
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = min ; i <= max ; i++){
            ans.add(map.get(i));
        }
        return ans;
    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}