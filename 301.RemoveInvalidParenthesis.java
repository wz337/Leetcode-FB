/*
    "()())()"
    / ||||||\
Level: each level represents the length of the solution string
State: we can try to remove the ith character for current string one at the time 
Termination: The leaf level would contains at least one valid solution. Anything above the level would be invalid.
Time: O(n!)  n! = n * (n - 1) * (n - 2) .... 1
Space: O(n!) for the extra string we used to store each potential solution 
*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 1) {
            result.add("");
            return result;
        }
        
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.offer(s);
        visited.add(s);
        boolean foundSolution = false;
        
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                result.add(cur);
                foundSolution = true;
            }
            //If a solution is found, there is no need to go further in the recursion tree. Just empty the queue.
            if (foundSolution) {
                continue;
            }
            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) == '(' || cur.charAt(i) == ')') {
                    if (i > 0 && cur.charAt(i) == cur.charAt(i - 1)) {  
                        //"((()" remove the 2nd and 3rd left would have result in the same string as remove the 1st left "()"
                        continue;
                    } 
                    String next = cur.substring(0, i) + cur.substring(i + 1);
                    if (visited.contains(next)) {
                        continue;
                    }
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return result;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            //That means we have a right parenthesis appearing before a left parenthesis
            if (count < 0) {  
                return false;
            }
        }
        return count == 0;
    }
}
