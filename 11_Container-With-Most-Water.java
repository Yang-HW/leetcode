/*
This is a easy follow up quesiton of two pointer.

basic idea: the brute force way of this problem is traverse the array two times.
so we should do some optimization on it because some traversing results is useless,
and our target is to find somes rules to avoiding the useless traversal. However,
this array is not sorted, so we could not begin with two pointer from the very begining,
because we don't know which one should be skipped, so basic thought is that put
pointer at the front and the end, and make the window shrink. Moreover, buckets effect
dominatet the pointer's movement.

area = (hi - lo) * height[hi or lo]

Example: give a array like:
[1, 5, 2, 3, 7, 8, 1]
 0  1  2  3  4  5  6
 low pointer begin with index 0, high pointer begin with index 6;

Time complexity: O(n)
*/

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



/*public class Solution {
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
*/
