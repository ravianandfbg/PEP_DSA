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

      public static TreeNode constructFromInOrder(int[] inOrder) {
            return helper(inOrder, 0, inOrder.length - 1);
      }

      public static TreeNode helper(int[] nums, int lo, int hi) {
            if (lo > hi) {
                  return null;
            }
            int mid = (lo + hi) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = helper(nums, lo, mid - 1);
            node.right = helper(nums, mid + 1, hi);
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
            int[] in = new int[n];
            for (int i = 0; i < n; i++)
                  in[i] = scn.nextInt();
            TreeNode root = constructFromInOrder(in);
            display(root);
      }

      public static void main(String[] args) {
            solve();
      }
}