// time : O(log n*m)

class Solution {
      public boolean searchMatrix(int[][] matrix, int target) {
          int pr = findPotentialRow(matrix , target); // pr : potential row    time : O(log N)
          
          if(pr == -1){
              return false;
          }
          return binarySearch(matrix , pr , target); // time : O(log M)
      }
      
      public static int findPotentialRow(int[][] matrix , int target){
          int lo = 0;
          int hi = matrix.length - 1;
          int lc = matrix[0].length - 1; // lc : last column
          
          while(lo <= hi){
              int mid = (lo + hi) / 2;
              
              if(matrix[mid][0] <= target && matrix[mid][lc] >= target){
                  return mid;
              }
              else if(matrix[mid][0] > target){
                  hi = mid - 1;
              }
              else{
                  lo = mid + 1;
              }
          }
          return -1;
      }
      
      public static boolean binarySearch(int[][] matrix , int row , int target){
          int lo = 0;
          int hi = matrix[0].length - 1;
          
          while(lo <= hi){
              int mid = (lo + hi) / 2;
              
              if(matrix[row][mid] == target){
                  return true;
              }
              else if(matrix[row][mid] < target){
                  lo = mid + 1;
              }
              else{
                  hi = mid - 1;
              }
          }
          return false;
      }
  }