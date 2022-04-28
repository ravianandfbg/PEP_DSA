// time : O(N)
// space : O(1)

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int maxReach = 0;
        int chunks = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            maxReach = Math.max(maxReach , arr[i]);
            
            if(maxReach == i){
                chunks++;
            }
        }
        return chunks;
    }
}