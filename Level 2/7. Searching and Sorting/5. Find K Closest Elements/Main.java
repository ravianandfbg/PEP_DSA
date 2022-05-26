// time : O(NlogK + KlogK) using priority queue

// if array is sorted we will use Binary search 
// time : O(log(N-k) + k)


class Solution {
      public static class Pair implements Comparable<Pair>{
          int val;
          int gap;
          
          Pair(){
              
          }
          
          Pair(int val , int gap){
              this.val = val;
              this.gap = gap;
          }
          public int compareTo(Pair o){
              if(this.gap != o.gap){
                  return this.gap - o.gap;
              }
              else{
                  return this.val - o.val;
              }
          }
      }
      
      public List<Integer> findClosestElements(int[] arr, int k, int x) {
          PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap
          
          for(int i = 0 ; i < arr.length ; i++){
              if(pq.size() < k){
                  pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
              }
              else if(pq.peek().gap >Math.abs(arr[i] - x)){
                  pq.remove();
                  pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
              }
          }
          List<Integer> ans = new ArrayList<>();
          
          while(pq.size() > 0){
              Pair p = pq.remove();
              ans.add(p.val);
          }
          
          Collections.sort(ans);
          
          return ans;
      }
  }




  // time : O(N)

//   class Solution {
//     public List<Integer> findClosestElements(int[] arr, int k, int x) {
//         int lo = 0;
//         int hi = arr.length - 1;
        
//         while(hi - lo >= k){
//             if(Math.abs(arr[lo] - x) > Math.abs(arr[hi] - x)){
//                 lo++;
//             }
//             else{
//                 hi--;
//             }
//         }
        
//         List<Integer> ans = new ArrayList<>();
//         for(int i = lo ; i <= hi ; i++){
//             ans.add(arr[i]);
//         }
        
//         return ans;
//     }
// }