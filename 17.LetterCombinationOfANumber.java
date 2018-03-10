/*
      " "
    / | | \

Level: represents the current digit we are trying to map to letters
State: different letter that a digit can be mapped to 
Time: O(4^n) n represents the length of digits.
Space: O(n)  We could only go down to the level of the length of digits.
*/
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return result;
        }
        char[] cur = new char[digits.length()];
        String[] map = buildMap();
        dfs(digits, cur, 0, map, result);
        return result;
    }
    private void dfs(String digits, char[] cur, int index, String[] map, List<String> result) {
        if (index == cur.length) {
            result.add(new String(cur));
            return;
        }
        int mapIndex = digits.charAt(index) - '0';
        for (char c : map[mapIndex].toCharArray()) {
            cur[index] = c;
            dfs(digits, cur, index + 1, map, result);
        }
    }
    private String[] buildMap() {
        String[] map = new String[10];
        map[0] = " ";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        return map;
    }
}
