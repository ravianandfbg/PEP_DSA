public class Main {
      public static class Node{
            int data;
            Node left , right;
      }

      public static Node construct(int arr[] , int lo , int hi){
            if(lo > hi){
                  return null;
            }
            int mid = (lo+hi) / 2;
            Node node = new Node();
            node.data = arr[mid];

            node.left = construct(arr , lo , mid-1);
            node.right = construct(arr , mid+1 , hi);

            return node;
      }

      public static void display (Node node){

            if(node == null){
                  return;
            }
            System.out.print(node.left == null ? "." : node.left.data);
            System.out.print(" -> "+node.data+" -> ");
            System.out.println(node.right == null ? "." : node.right.data);

            display(node.left);
            display(node.right);
      }

      public static void main(String[] args){
            int arr[] = {10 , 20 , 30 , 40 , 50 , 60 , 70}; //sorted integer

            Node root = construct(arr , 0 , arr.length - 1);
            display(root);
      }
      
}
