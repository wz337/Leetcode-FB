class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int zero = 0;   //[0, zero) represents the interval for first color
        int one = 0;    //[zero, one) 
        int two = nums.length - 1;  //(two, nums.length - 1] 
        //area remained to be explored [one, two]
        while (one <= two) {
            if (nums[one] == 1) {
                one++;
            } else if (nums[one] == 0) {
                swap(nums, one++, zero++);
            } else {
                swap(nums, one, two--); //You don't know what the element you swap back is going to be. Still need to check.
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
