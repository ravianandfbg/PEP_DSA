public class Main {
      
      public int minMeetingRooms(List<Interval> intervals) {
          // Write your code here
          int n = intervals.size();
          int[] st = new int[n]; // st : strat time
          int[] et = new int[n]; // et : end time
  
          for(int i = 0 ; i < n ; i++){
              st[i] = intervals.get(i).start;
              et[i] = intervals.get(i).end;
          }
          
          Arrays.sort(st);
          Arrays.sort(et);
  
          int i = 0;
          int j = 0;
          int count = 0;
          int max = 0;
  
          while(i < n && j < n){
              if(st[i] < et[j]){
                  i++;
                  count++;
              }
              else{
                  count--;
                  j++;
              }
              max = Math.max(max , count);
          }
          return max;
      }
  }