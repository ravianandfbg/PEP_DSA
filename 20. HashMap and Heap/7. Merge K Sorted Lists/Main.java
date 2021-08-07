import java.io.*;
import java.util.*;

public class Main {
    
    //create Pair and comareTo
    public static class Pair implements Comparable<Pair>{
        int li , vi , val; // li : list index ; vi : value index 
        Pair(int li , int vi , int val){
            this.li = li;
            this.vi = vi;
            this.val = val;
        }
        public int compareTo(Pair o){ // o : other
            return this.val - o.val; // because we are finding min values
        }
    }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      
      for(int i = 0 ; i < lists.size() ; i++){
          pq.add(new Pair(i , 0 , lists.get(i).get(0)));
      }
      
      while(pq.size() > 0){
          Pair temp = pq.remove();
          
          rv.add(temp.val);
          
          if(temp.vi+1 < lists.get(temp.li).size()){
              temp.vi = temp.vi + 1;
              temp.val = lists.get(temp.li).get(temp.vi);
              pq.add(temp);
          }
      }

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}