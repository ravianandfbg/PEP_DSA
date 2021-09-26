import java.util.Scanner;

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

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
         int n = inorder.length;
       TreeNode root = helper(postorder , inorder , 0 , n - 1 , 0 , n - 1);
        
        return root;
        
    }
    //ps : postorder start   // pe : postorder end
    //is : inorder start  // ie : inorder end
    public static TreeNode helper(int[] post , int[] in , int ps , int pe , int is , int ie){
        if(ps > pe){
            return null;
        }
        
        TreeNode node  = new TreeNode(post[pe]);
        
        int k = -1;
        
        for(int i = is ; i <= ie ; i++){
            if(in[i] == node.val){
                k = i;
                break;
            }
        }
        int cls = k - is; // count of left subtree elements(wrt node)
        
        node.left = helper(post , in , ps, ps + cls - 1 , is , k - 1);
        node.right = helper(post , in , ps + cls, pe - 1 , k + 1 , ie);
        
        return node;
        
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}