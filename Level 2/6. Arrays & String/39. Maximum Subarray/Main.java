// use Kadane’s Algorithm
// T.C : O(N)
// S.c : O(1)

class Solution {
      public int maxSubArray(int[] nums) {
          int sum = nums[0];
          int max = nums[0];
          
          for(int i = 1 ; i < nums.length ; i++){
              if(sum > 0){
                  sum += nums[i];
              }
              else{
                  sum = nums[i];
              }
              max = Math.max(max , sum);
          }
          return max;
      }
  }