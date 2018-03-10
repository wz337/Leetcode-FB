/*
Time: O(2^n)
Space: O(n)
*/
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.length() < 1) {
            result.add("");
            return result;
        }
        char[] cur = new char[S.length()];
        dfs(S, cur, 0, result);
        return result;
    }
    private void dfs(String s, char[] cur, int index, List<String> result) {
        if (index == cur.length) {
            result.add(new String(cur));
            return;
        }
        char curLetter = s.charAt(index);
        cur[index] = curLetter;
        dfs(s, cur, index + 1, result);
        if (isLetter(curLetter)) {
            cur[index] = swap(curLetter);
            dfs(s, cur, index + 1, result);
        }
    }
    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >='A' && c <= 'Z';
    }
    private char swap(char c) {
        if (c < 'a') {
            c = (char)(c + ('a' - 'A'));
        } else {
            c = (char)(c - ('a' - 'A'));
        }
        return c;
    }
}
