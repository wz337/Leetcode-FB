//Time: O(n)
//Space: O(n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2) {
            return new int[]{};
        }
        int[] reverse = new int[nums.length];
        //reverse[] record the current product starting from position i (excluding ith element)
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i == nums.length - 2) {
                reverse[i] = nums[i + 1];
            } else {
                reverse[i] = nums[i + 1] * reverse[i + 1];
            }
        }
        //product[] record the current product starting from 0 to ith position (excluding ith element)
        int[] product = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (i == 1) {
                product[i] = nums[i - 1];
            } else {
                product[i] = product[i - 1] * nums[i - 1];
            }
        }
        //So the final result for position i is reverse[i] * product[i]. Beaware of corner cases, 0 and the last element.
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = reverse[i];
            } else if (i == nums.length - 1) {
                result[i] = product[i];
            } else {
                result[i] = product[i] * reverse[i];
            }
        }
        return result;
    }
}
