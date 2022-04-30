
// T.C : O(NlogN) + O(N)
// S.c : O(N)

public class Main{
    public static int[][] mergeIntervals(int intervals[][]){
        ArrayList<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals , (a,b) -> {
            // 0 -> a = b
            // negative -> a < b
            // positive -> a > b
            return a[0] - b[0];
        });
        
        ans.add(intervals[0]);
        
        int i = 1;
        
        while(i < intervals.length){
            
            int li = ans.size() - 1;
            
            if(intervals[i][0] <= ans.get(li)[1]){
                ans.get(li)[1] = Math.max(ans.get(li)[1] , intervals[i][1]);
            }
            else{
                ans.add(intervals[i]);
                li++;
            }
            i++;
        }
        
        int[][] res = new int[ans.size()][2];
        res = ans.toArray(res);
        
        return res;
    }
}