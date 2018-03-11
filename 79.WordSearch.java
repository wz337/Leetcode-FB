//Time: search at per character: O(4^l), l = len(word)
//Space: O(l) 
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length < 1 || board[0].length < 1) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        char curLetter = board[i][j];
        board[i][j] = '#';
        int[][] dir = new int[][]{{1, 0},{0, 1},{-1, 0},{0, -1}};
        boolean exist = false;
        for (int[] pair : dir) {
            exist = exist || dfs(board, i + pair[0], j + pair[1], word, index + 1);
        }
        board[i][j] = curLetter;
        return exist;
    }
}
