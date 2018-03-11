//Time: O(n^3), we are calling the api for substring that takes O(n) of time
//Space: O(n)
class Solution {
   
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() < 1) {
            return false;
        }
        Set<String> dict = new HashSet<>(wordDict);
        //dp[i] denotes whether the word ending at index i in the string is included in the wordDict
        //base case: dp[0] = true;
        //induction rule: dp[i] = true, if s.substring(0, i) is in wordDict
        //or if there exists a j < i such that dp[j] = true and s.substring(j, i) is in the wordDict
        boolean[] dp = new boolean[s.length() + 1];
        //Sometimes it will be handy to have such index matching, 
        //dp[i] represents index(i - 1) in input, also can represent the substring(0, i)
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) { 
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; //no need to check further
                }
            }
        }
        return dp[s.length()];
    }
}
