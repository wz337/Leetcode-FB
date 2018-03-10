class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(')');
            } else if (c == '{') {
                stack.offerFirst('}');
            } else if (c == '[') {
                stack.offerFirst(']');
            } else if (stack.isEmpty() || stack.pollFirst() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
