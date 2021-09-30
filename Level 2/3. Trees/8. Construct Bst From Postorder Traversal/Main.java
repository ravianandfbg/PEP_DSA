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

      static int idx;

      public static TreeNode bstFromPostorder(int[] post, int n) {
            idx = n - 1;
            return helper(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
      }

      public static TreeNode helper(int[] post, int min, int max) {
            if (idx < 0 || post[idx] < min || post[idx] > max) {
                  return null;
            } else {
                  TreeNode node = new TreeNode(post[idx]);
                  idx--;
                  node.right = helper(post, node.val, max);
                  node.left = helper(post, min, node.val);
                  return node;
            }
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
            TreeNode root = bstFromPostorder(pre, n);
            display(root);
      }

      public static void main(String[] args) {
            solve();
      }
}