// similar to Q 2. Range Addition

class Main {
      public boolean carPooling(int[][] trips, int capacity) {
          int max = 0;
          
          for(int[] trip : trips){
              int ep = trip[2]; // ep : ending point
              max = Math.max(max , ep);
          }
          
          int[] arr = new int[max+1];
          
          for(int[] trip : trips){
              int np = trip[0]; // np : number of passenger
              int sp = trip[1]; // sp : starting point
              int ep = trip[2]; // ep : ending point
              
              arr[sp] += np;
              arr[ep] -= np;
          }
          
          int ps = 0; // prefix sum
          
          for(int i = 0 ; i < arr.length ; i++){
              ps += arr[i];
              
              if(ps > capacity){
                  return false;
              }
          }
          return true;
      }
  }