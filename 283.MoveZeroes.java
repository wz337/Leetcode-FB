class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int nonZero = 0; // [0,nonZero)
        int zero = 0; // [nonZero, zero) 
        //interval remained to be explored [zero, nums.length - 1]
        while (zero < nums.length) {
            if (nums[zero] == 0) {
                zero++;
            } else {
                swap(nums, zero++, nonZero++);
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
