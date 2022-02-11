// Time : O(n * m)          space : O(m)  n : no. of rows , m : no. of column

class Solution {
    
      public int[] nextSmallerLeft(int[] arr){
           int n = arr.length;
           int[] ans = new int[n];
           Stack<Integer> st = new Stack<>();
           
           ans[0] = -1;
           st.push(0);
           
           for(int i = 1 ; i < n ; i++){
               while(st.size() > 0 && arr[st.peek()] >= arr[i]){
                   st.pop();
               }
               if(st.size() == 0){
                   ans[i] = -1;
               }
               else{
                   ans[i] = st.peek();
               }
               st.push(i);
           }
           return ans;
       } 
       
       public int[] nextSmallerRight(int[] arr){
           int n = arr.length;
           int[] ans = new int[n];
           Stack<Integer> st = new Stack<>();
           
           ans[n - 1] = n;
           st.push(n - 1);
           
           for(int i = n - 2 ; i >= 0 ; i--){
               while(st.size() > 0 && arr[st.peek()] >= arr[i]){
                   st.pop();
               }
               if(st.size() == 0){
                   ans[i] = n;
               }
               else{
                   ans[i] = st.peek();
               }
               st.push(i);
           }
           return ans;
       }
       
       public int largestRectangleArea(int[] heights) {
           int[] nsl = nextSmallerLeft(heights); // nsl : next smaller on left
           int[] nsr = nextSmallerRight(heights); // nsr : next Smaller on right
           
           int ans = 0;
           
           for(int i = 0 ; i < heights.length ; i++){
               int width = nsr[i] - nsl[i] - 1;
               int h = heights[i];
               
               int area = h * width;
               
               ans = Math.max(ans , area);
           }
           return ans;
       }
     
     public int maximalRectangle(char[][] matrix) {
         int n = matrix.length;
         int m = matrix[0].length;
         int[] arr = new int[m];
         int max = 0;
         
         for(int i= 0 ;i < n; i++){
             for(int j = 0 ; j < m ; j++){
                 if(matrix[i][j] ==  '0'){
                     arr[j] = 0;
                 }
                 else{
                     arr[j] += 1;
                 }
             }
             int area = largestRectangleArea(arr);
             max = Math.max(area , max);
         }
         return max;
     }
 }