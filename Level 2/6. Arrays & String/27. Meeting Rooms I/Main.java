public class Main {
      /**
       * @param intervals: an array of meeting time intervals
       * @return: if a person could attend all meetings
       */
      public boolean canAttendMeetings(List<Interval> intervals) {
          // Write your code here
  
          if(intervals.size() == 0){
              return true;
          }
  
          Collections.sort(intervals , (a,b) -> {
              return a.start - b.start;
          });
  
          int liep = intervals.get(0).end; // liep : last interval end point
          int i = 1;
  
          while(i < intervals.size()){
              int isp = intervals.get(i).start; // isp : interval starting point
              if(isp < liep){
                  return false;
              }
              else{
                  liep = Math.max(intervals.get(i).end , liep);
              }
              i++;
          }
          return true;
      }
  }