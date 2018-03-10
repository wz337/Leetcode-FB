class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length()) {
            return "";
        }
        //map size = the number of unique character in t
        //When all the value of the keys goes to 0 in the map, it means we found a match.
        Map<Character, Integer> map = buildMap(t);  
        int match = 0, min = Integer.MAX_VALUE;
        int j = 0, solStart = 0; //j: left size of the sliding window (inclusive)
        
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            Integer count = map.get(cur);
            if (count != null) {
                if (count == 1) { //when the value of a key goes down from 1 to 0, we find a match.
                    match++;
                }
                map.put(cur, count - 1);
            }
            while (match == map.size()) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    solStart = j;
                }
                cur = s.charAt(j++);
                count = map.get(cur);
                if (count != null) {
                    if (count == 0) { //when the value of a key goes from 0 to 1, we lose a match. 
                        match--;
                    }
                    map.put(cur, count + 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(solStart, solStart + min);
    }
    private Map<Character, Integer> buildMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
