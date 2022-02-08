// Binary Search

// Time : O(NlogN)           space : O(1)

// Exactly same as ques. 24 (Allocate Minimum Number of Pages)

class Solution {
      public int splitArray(int[] nums, int m) {
          int max = nums[0];
          int sum = 0;
          
          for(int val : nums){
              sum += val;
              max = Math.max(max , val);
          }
          
          int lo = max;
          int hi = sum;
          int ans = 0;
          
          while(lo <= hi){
              int mid = lo + (hi - lo) / 2;
              
              if(isPossible(nums , mid , m) == true){
                  ans = mid;
                  hi = mid - 1;
              }
              else{
                  lo = mid + 1;
              }
          }
          return ans;
      }
      
      public static boolean isPossible(int[] arr , int mid , int m){
          int st = 1; // st : number of student
          int sum = 0;
          
          for(int i = 0 ; i < arr.length ; i++){
              sum += arr[i];
              
              if(sum > mid){
                  st++;
                  sum = arr[i];
              }
          }
          return st <= m;
      }
  }