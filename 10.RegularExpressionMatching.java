/*
dp[i][j] represents whether the string ending at i (exclusive) matches with pattern ending at j (exclusive)
Base case: dp[0][0] = true (since empty string matches with empty pattern)
Induction Rule: 
if p(j-1) != '*' && (s(i - 1) = p(j - 1) || p(j - 1) = '.'): dp[i][j] = dp[i-1][j-1] (from the diagonal)
if p(j-1) == '*' && matches empty   1) when there is 0 occurences of the value before * in pattern j:
                                     dp[i][j] = dp[i-2][j] (from the left)
if p(j-1) == '*' && s(i-1) = p(j-2)  2) that is when there is one or more occurences of the value before * in pattern j:
                                     dp[i][j] = dp[i-1][j] (from the top)
otherwise: no match: dp[i][j] = false
*/
// * matches 0 or more occurences of character before *
// . matches any single character
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1]; 
        dp[0][0] = true; //empty string matches empty pattern
        
        //deals with patterns like a* or a*b* or a*b*c* ([true, false, true, false, true, false, true]) for last example
        for (int j = 1; j < n; j+=2) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = dp[0][j - 1];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i-1][j-1] && isMatch(s.charAt(i-1), p.charAt(j-1));
                } else {
                    //match 0 occurences || matches 1 or more occurences
                    dp[i][j] = dp[i][j-2] || dp[i-1][j] && isMatch(s.charAt(i-1), p.charAt(j-2));
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }
    private boolean isMatch(char s, char p) {
        return p == '.' || s == p;
    }
}

/*
  0 x a * b . c
0 T F F F F F F
x F T F T F F F
a F F T T F F F
a F F F T F F F
b F F F F T F F
y F F F F F T F
c F F F F F F T

  0 a * b * c *
0 T F T F T F T
a F T T F T F T
b F F F T T F T
c F F F F F T T
*/


