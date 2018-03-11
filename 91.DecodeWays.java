/*
dp[i] represents how many ways there are to decode current string ending at i
base case: dp[0] = 1 if (s.charAt(0) != '0'); 0 otherwise
induction rule: 1) dp[i] = dp[i - 1] if s.charAt(i) != 0
                   dp[i] += dp[i - 2] if s.substring(i - 1, i + 1) can represents a valid number 
*/
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        } 
        // int[] dp = new int[s.length()];
        // dp[0] = 1;
        int[] dp = new int[]{0, 1, 0}; 
        //element 0 represents minus two step, element 1 represents prev step, elements 2 represents current step
        for (int i = 1; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (cur != 0) {
                dp[2] = dp[1];
            }
            cur += (s.charAt(i - 1) - '0') * 10; 
            if (cur >= 10 && cur <= 26) {
                if (i == 1) {
                    dp[2]++;
                } else {
                    dp[2] += dp[0];
                }
            } else if (cur % 10 == 0) {
                return 0;
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = 0;  //remember to reset dp[2]
        }
        return dp[1];
    }
}
