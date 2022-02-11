// Time : O(N)          Space : O(N)

class Solution {
      public int[] nextGreaterElements(int[] nums) {
          int n = nums.length;
          int[] nge = new int[n]; // nge : nextgreater element
          
          Stack<Integer> st = new Stack<>();
          
          for(int i = n - 1 ; i >= 0 ; i--){
              while(st.size() > 0 && st.peek() <= nums[i]){
                  st.pop();
              }
              st.push(nums[i]);
          }
          
          for(int i = n - 1 ; i >= 0 ; i--){
              while(st.size() > 0 && st.peek() <= nums[i]){
                  st.pop();
              }
              
              if(st.size() == 0){
                  nge[i] = -1;
              }
              else{
                  nge[i] = st.peek();
              }
              st.push(nums[i]);
          }
          return nge;
      }
  }