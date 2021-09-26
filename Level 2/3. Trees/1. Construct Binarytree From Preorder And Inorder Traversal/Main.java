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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
       TreeNode root = helper(preorder , inorder , 0 , n - 1 , 0 , n - 1);
        
        return root;
        
    }
    //ps : preorder start   // pe : preorder end
    //is : inorder start  // ie : inorder end
    public static TreeNode helper(int[] pre , int[] in , int ps , int pe , int is , int ie){
        if(ps > pe){
            return null;
        }
        
        TreeNode node  = new TreeNode(pre[ps]);
        
        int k = -1;
        for(int i = is ; i <= ie ; i++){
            if(in[i] == node.val){
                k = i;
                break;
            }
        }
        int cls = k - is; // count of left subtree elements(wrt node)
        
        node.left = helper(pre , in , ps + 1, ps + cls , is , k - 1);
        node.right = helper(pre , in , ps + cls + 1 , pe , k + 1 , ie);
        
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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}