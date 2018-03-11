//Time: O(m*n)
//Space: O(m*n)
//Base Case: if i == 0 || j == 0, dp[i][j] = matrix[i][j] - '0'
//           else: dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length, max = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + 1;
                        dp[i][j] = Math.min(dp[i][j], dp[i][j-1] + 1);
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
        }
        return max * max;
    }
}
