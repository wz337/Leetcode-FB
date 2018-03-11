//Time: O(n)
//Space: O(1)

//Elements of the given array are in the range of 0 to 10^9
//Length of the array will not exceed 10^4.
//数据规模比较大 10^4 ==> 我们只能使用O(N) 或者 O(NlgN)

//Brute Force: O(n^2) --> calculate all differences --> Time: O(N^2)
//Better Solution: O(N) --> Check bit by bit --> Imagine we are drawing a large table
/*  0100
    1110    
    0010
*/
class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int one = 0;
            int zero = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & 1) == 1) {
                    one++;
                } else {
                    zero++;
                }
                nums[i] >>= 1;
            }
            res += one * zero;
        }
        return res;
    }
}
