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
      public static class Pair {
            TreeNode par;
            int min;
            int max;

            Pair() {
            }

            Pair(TreeNode par, int min, int max) {
                  this.par = par;
                  this.min = min;
                  this.max = max;
            }
      }

      public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder) {
            ArrayDeque<Pair> q = new ArrayDeque<>();
            q.add(new Pair(null, Integer.MIN_VALUE, Integer.MAX_VALUE));
            TreeNode root = null;
            int idx = 0;
            while (q.size() > 0 && idx < LevelOrder.length) {
                  Pair rem = q.remove();
                  if (LevelOrder[idx] < rem.min || LevelOrder[idx] > rem.max) {
                        continue;
                  }
                  TreeNode node = new TreeNode(LevelOrder[idx]);
                  idx++;
                  if (rem.par == null) {
                        root = node;
                  } else {
                        if (rem.par.val > node.val) {
                              rem.par.left = node;
                        } else {
                              rem.par.right = node;
                        }
                  }
                  q.add(new Pair(node, rem.min, node.val - 1));
                  q.add(new Pair(node, node.val + 1, rem.max));
            }
            return root;
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
            int[] level = new int[n];
            for (int i = 0; i < n; i++)
                  level[i] = scn.nextInt();
            TreeNode root = constructBSTFromLevelOrder(level);
            display(root);
      }

      public static void main(String[] args) {
            solve();
      }
}