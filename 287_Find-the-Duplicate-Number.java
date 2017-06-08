/*
1. sort + traversal? dissatisfy the array can read only.
2. how to use the property of only one repeated element exist?
3. using the value as the index:
array: 2, 5, 1, 1, 4, 3
index: 0, 1, 2, 3, 4, 5
2 --> 1 --> 5 --> 3 --> 1 --> 5 --> 3 ...
so there is a circle in the array, and this problem will be same as the 142_Linked-List-Cycle-II

Basic idea: using the value as index, so if some repeated element exist, there will be a cycle
in traversal using value.

Running time: O(n)

*/
public class Solution {
    public int findDuplicate(int[] nums) {
        if(nums.length > 1){
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            slow = 0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
        return -1;
    }
}
