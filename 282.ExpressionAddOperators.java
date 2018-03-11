//Time: O(4^n)
//Space: O(n)
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() < 1) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        dfs(result, sb, num, target, 0, 0, 0);
        return result;
    }
    private void dfs(List<String> result, StringBuilder sb, String num, int target, int index, long curEval, long prevEval) {
        if (index == num.length()) {
            if (curEval == target) {
                result.add(sb.toString());
            }
            return;
        } 
        
        for (int i = index; i < num.length(); i++) {
            //"0" cannot be the leading number. For example, if we have 03, break from the loop. No need to check all later solutions.
            if (num.charAt(index) == '0' && i != index) {
                break;
            }
            long cur = Long.valueOf(num.substring(index, i + 1));
            int len = sb.length(); //Record the length so we can backtrack
            //When index is 0, we cannot add operator before it.
            if (index == 0) {
                dfs(result, sb.append(cur), num, target, i + 1, curEval + cur, cur);
            } else {
                dfs(result, sb.append("+").append(cur), num, target, i + 1, curEval + cur, cur);
                sb.setLength(len);
                dfs(result, sb.append("-").append(cur), num, target, i + 1, curEval - cur, -cur);
                sb.setLength(len);
                dfs(result, sb.append("*").append(cur), num, target, i + 1, curEval - prevEval + prevEval * cur, prevEval * cur);
            }
            sb.setLength(len);
        }
    }
}
