// Kadane's Algorithm
// time : O(N)

class Main {
      int m = 1000000007;
      
      public int kConcatenationMaxSum(int[] arr, int k) {
          if(k == 1){
              return OneArrKadanes(arr);
          }
          
          int sum = 0;
          for(int val : arr){
              sum += val;
          }
          
          int res = TwoArrKadanes(arr);
          
          if(sum > 0){
              long ans = res + ((long)(k - 2) * sum);
              return (int)(ans % m);
          }
          else{
              return res;
          }
      }
      
      public int TwoArrKadanes(int[] arr){
          int sum = arr[0];
          int max = Math.max(sum , 0);
          
          for(int i = 1 ; i < 2 * arr.length ; i++){
              
              int idx = i % arr.length;
              
              if(sum > 0){
                  sum += arr[idx];
              }
              else{
                  sum = arr[idx];
              }
              max = Math.max(sum , max);
          }
          return max;
      }
      
      public int OneArrKadanes(int[] arr){
          int sum = arr[0];
          int max = Math.max(sum , 0);
          
          for(int i = 1 ; i < arr.length ; i++){
              
              if(sum > 0){
                  sum += arr[i];
              }
              else{
                  sum = arr[i];
              }
              max = Math.max(sum , max);
          }
          return max;
      }
  }