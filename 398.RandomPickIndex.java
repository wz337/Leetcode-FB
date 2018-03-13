/*
For the nth target, ++count is n. Then the probability that r.nextInt(++count) == 0 is 1/n. 
Thus, P(returning nth target) = 1/n.
For n - 1 target, ++count is n - 1. The probability r.nextInt(++count) == 0 is 1/(n-1).
Thus, P(returning n-1th target) = (n-1)/n (picking n - 1 numbers out of n numbers) * (1 * (n - 1)) (picking the 1 element) = 1/n
*/
class Solution {
    private int[] nums;
    private Random r;

    public Solution(int[] nums) {
        this.nums = nums;
        r = new Random();
    }
    
    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (r.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
