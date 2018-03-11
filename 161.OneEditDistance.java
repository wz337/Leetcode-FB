class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null || s.length() < 1 && t.length() < 1 || s.equals(t)) {
            return false;
        }
        if (s.length() == t.length()) {
            return isReplaceable(s, t);
        }
        if (s.length() + 1 == t.length()) {
            return isDeleted(s, t);
        }
        if (t.length() + 1 == s.length()) {
            return isDeleted(t, s);
        }
        return false;
    } 
    private boolean isReplaceable(String s, String t) {
        boolean replaced = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (replaced) {
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }
    private boolean isDeleted(String s, String l) {
        if (s.length() == 0) {
            return l.length() == 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != l.charAt(i)) {
                return s.substring(i).equals(l.substring(i+1));
            }
        }
        //s == l.substring(0, s.length()) && l.charAt(s.length()) is the one extra character
        return true;
    }
}
