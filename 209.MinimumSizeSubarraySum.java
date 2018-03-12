class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0, left = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {  //add nums[i] until sum is greater or equal to s
                if (i - left + 1 < min) {  
                    min = i - left + 1;
                }
                sum -= nums[left++]; //shrink subarray
            }
        }
        //If there is none, min is still equal to Integer.MAX_VALUE. Remember to check.
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
