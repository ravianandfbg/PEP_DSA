class Solution {
      static class Pair{
          int id;
          int st; // st : starting time
          int wt; // wt : waiting time
          
          Pair(){
              
          }
          
          Pair(int id , int st , int wt){
              this.id = id;
              this.st = st;
              this.wt = wt;
          }
      }
      public int[] exclusiveTime(int n, List<String> logs) {
          int[] ans = new int[n];
          Stack<Pair> st = new Stack<>();
          
          for(String log : logs){
              String[] arr = log.split(":");
              int id = Integer.parseInt(arr[0]);
              String action = arr[1];
              int time = Integer.parseInt(arr[2]);
              
              if(action.equals("start") == true){
                  st.push(new Pair(id , time , 0));
              }
              else{
                  int tts = time - st.peek().st + 1; // total time spend(tts) = exection_time + waiting time 
                  int exection_time = time - st.peek().st + 1 - st.peek().wt;
                  ans[st.peek().id] += exection_time;
                  st.pop();
                  
                  if(st.size() > 0){
                      // parent exists
                      st.peek().wt += tts;
                  }
              }
          }
          return ans;
      }
  }