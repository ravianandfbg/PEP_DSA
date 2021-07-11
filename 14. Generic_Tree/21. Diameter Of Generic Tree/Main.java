import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  
  //i have intialized
  static int diaOfTree; // diaOfTree : diameter of tree 
  
  public static int diameter(Node node){
      //height
      
      int lh = -1 , slh = -1; // lh: largest height , slh : second largest height
      
      for(Node child : node.children){
          int cht = diameter(child); // cht = child height
          
          if(cht > lh){
              slh = lh;
              lh = cht;
          }
          else if(cht > slh){
              slh = cht;
          }
      }
      
      int diaOfNode = lh+slh+2;
      if(diaOfNode > diaOfTree){
          diaOfTree = diaOfNode;
      }
      return lh+1;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    
    diaOfTree = 0;
    diameter(root); // returns height
    System.out.println(diaOfTree);
  }

}