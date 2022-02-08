// Binary Search

// Time : O(NlogN)           space : O(1)

// Exactly same as ques. 24 (Allocate Minimum Number of Pages) 

class Solution {
      public int shipWithinDays(int[] weights, int days) {
          int max = weights[0];
            int sum = 0;
            
            for(int val : weights){
                sum += val;
                max = Math.max(max , val);
            }
            
            int lo = max;
            int hi = sum;
            int ans = 0;
            
            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                
                if(isPossible(weights , mid , days) == true){
                    ans = mid;
                    hi = mid - 1;
                }
                else{
                    lo = mid + 1;
                }
            }
            return ans;
        }
        
        public static boolean isPossible(int[] arr , int mid , int days){
            int capacity = 1;
            int sum = 0;
            
            for(int i = 0 ; i < arr.length ; i++){
                sum += arr[i];
                
                if(sum > mid){
                    capacity++;
                    sum = arr[i];
                }
            }
            return capacity <= days;
      }
  }
