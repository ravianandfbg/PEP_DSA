// Time : O(N)          Space : O(1)

class CustomStack {
      int[] value;
      int[] increment;
      int tos; // tos : top of the stack
  
      public CustomStack(int maxSize) {
          value = new int[maxSize];
          increment = new int[maxSize];
          tos = -1;
      }
      
      public void push(int x) {
          if(tos + 1 == value.length){
              // overflow 
              return;
          }
          
          tos++;
          value[tos] = x;
      }
      
      public int pop() {
          if(tos == -1){
              // underflow
              return -1;
          }
          
          int rv = value[tos] + increment[tos]; // rv : return value
          int inc = increment[tos];
          
          value[tos] = increment[tos] = 0;
          tos--;
          
          if(tos >= 0){
              increment[tos] += inc;
          }
          
          return rv;
      }
      
      public void increment(int k, int val) {
          if(tos == -1){
              return;
          }
          
          if(k > tos + 1){
              increment[tos] += val;
          }
          else{
              increment[k - 1] += val;
          }
      }
  }