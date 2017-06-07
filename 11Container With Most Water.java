public class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int area = (hi - lo) * Math.min(height[lo], height[hi]);
        while(lo <= hi && lo <= height.length - 1){
            area = Math.max(area, (hi - lo) * height[hi]);
            if(height[lo] >= height[hi])
                hi--;
            else
                lo++;
        }
        return area;
    }
}



public class Solution {
    public int maxArea(int[] height) {
        int lo = 0, hi = height.length - 1;
        int area = (hi - lo) * Math.min(height[lo], height[hi]);
        while(lo <= hi && lo <= height.length - 1){
            if(height[lo] >= height[hi]){
                area = Math.max(area, (hi - lo) * height[hi]);
                hi--;
            }else if(height[lo] < height[hi]){
                area = Math.max(area, (hi - lo) * height[lo]);
                lo++;
            }
        }
        return area;
    }
}
