class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) { //Test case: [1], 1
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] <= nums[mid]) { //if the left portion is sorted
                if (target < nums[mid] && target >= nums[left]) { //if the target is in the sorted portion
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { //if the right portion is sorted
                if (target > nums[mid] && target <= nums[right]) { //if the target is in the sorted portion
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
