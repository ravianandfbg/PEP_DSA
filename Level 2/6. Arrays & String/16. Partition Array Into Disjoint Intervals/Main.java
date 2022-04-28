
// time : O(N) , space : O(1)

class Solution {
      public int partitionDisjoint(int[] nums) {
          
          
          int lmax = nums[0]; // lmax : left max
          int pmax = nums[0]; // pmax : previous max (maximum of potential ans's left hand side)
          int pa = 0; // pa : potential answer
          
          for(int i = 1 ; i < nums.length ; i++){
              if(nums[i] >= lmax){
                  lmax = nums[i];
              }
              else if(nums[i] < pmax){
                  pa = i;
                  pmax = lmax;
              }
          }
          return pa + 1;
      }
  }







// time :O(N) , space O(N)

// public static int partitionDisjoint(int[] arr) {
//       // write your code here
      
    //   // time : O(N)
    //   // space : O(N)
      
    //   int[] lmax = new int[arr.length]; // lmax : left max
    //       int[] rmin = new int[arr.length + 1]; // rmin : right minimum
          
    //       lmax[0] = arr[0];
          
    //       for(int i = 1 ; i < arr.length ; i++){
    //           lmax[i] = Math.max(lmax[i - 1] , arr[i]);
    //       }
          
    //       rmin[arr.length] = Integer.MAX_VALUE;
          
    //       for(int i = arr.length - 1 ; i >= 0 ; i--){
    //           rmin[i] = Math.min(rmin[i + 1] , arr[i]);
    //       }
          
    //       int chunks = 0;
          
    //       for(int i = 0 ; i < arr.length ; i++){
    //           if(lmax[i] <= rmin[i + 1]){
    //               return i + 1;
    //           }
    //       }
    //       return -1;
//     }