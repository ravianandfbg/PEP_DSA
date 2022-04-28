// // TWO POINTER
// time : O(N)

class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        
        int maxArea = 0;
        
        while(i <= j){
            int width = j - i;
            int area = width * Math.min(height[i] , height[j]);
            
            if(area > maxArea){
                maxArea = area;
                }
            
            if(height[i] < height[j]){
                    i++;
            }
            else{
                j--;
            }
        }
        return maxArea;
    }
}