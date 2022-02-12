// Time : O(N)           space : O(1)

// two pointers approach

class Solution {
      public boolean validateStackSequences(int[] pushed, int[] popped) {
          int i = 0;
          int j = 0;
          int count = 0;
          
          Stack<Integer> st= new Stack<>();
          int n = pushed.length;
          
          while(j < n){
              if(st.size() > 0 && popped[j] == st.peek()){
                  st.pop();
                  j++;
                  count++;
              }
              else if(i < n){
                  st.push(pushed[i]);
                  i++;
              }
              else{
                  return false;
              }
          }
          return count == n;
      }
  }