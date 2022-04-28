// time : O(N)
// space : O(N)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int lp[] = new int[n]; // lp : left product
        int rp[] = new int[n]; // rp : right product
        
        lp[0] = nums[0];
        
        for(int i = 1 ; i < n ; i++){
            lp[i] = lp[i - 1] * nums[i];
        }
        
        rp[n-1] = nums[n-1];
        
        for(int i = n - 2 ; i >= 0 ; i--){
            rp[i] = nums[i] * rp[i + 1];
        }
        
        int[] ans = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            int pes = (i == 0 ? 1 : lp[i - 1]) * (i == n - 1 ? 1 : rp[i + 1]); //pes : product except self
            ans[i] = pes;
        }
        
        return ans;
    }
}