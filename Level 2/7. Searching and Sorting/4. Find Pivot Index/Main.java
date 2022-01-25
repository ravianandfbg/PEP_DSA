// time : O(N)       space : O(1)

class Solution {
      public int pivotIndex(int[] nums) {
          int sum = 0;
          
          for(int val : nums){
              sum += val;
          }
          
          int rsum = sum; // rsum : right sum
          int lsum = 0; // lsum : left sum
          
          for(int i = 0 ; i < nums.length ; i++){
              rsum -= nums[i];
              
              if(lsum == rsum){
                  return i;
              }
              lsum += nums[i];
          }
          return -1;
      }
  }