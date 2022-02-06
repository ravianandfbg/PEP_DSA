// Biary Search

// Time : O(N log M)  where N = length of piles    ,    M = maximum value of array
// space : O(1)


class Solution {
      public int minEatingSpeed(int[] piles, int h) {
          int max = piles[0];
          
          for(int val : piles){
              max = Math.max(max , val);
          }
          
          if(h == piles.length){
              return max;
          }
          
          int lo = 0 , hi = max;
          int ans = 0;
          
          while(lo <= hi){
              int mid = lo + (hi - lo) / 2;
              
              if(isPossible(piles , mid , h) == true){
                  ans = mid;
                  hi = mid - 1;
              }
              else{
                  lo = mid + 1;
              }
          }
          return ans;
      }
      
      public static boolean isPossible(int[] piles , int speed , int h){
          int time = 0; // total time
          
          for(int i = 0 ; i < piles.length ; i++){
              time += Math.ceil(piles[i] * 1.0 / speed);
          }
          
          return time <= h;
      }
  }