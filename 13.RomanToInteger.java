class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        Map<Character, Integer> map = buildMap();
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (i == s.length() - 1) {
                sum += cur;
            } else {
                //If current roman character is greater or equal to the one in i + 1 place, add it to the sum
                if (cur >= map.get(s.charAt(i + 1))) {
                    sum += cur;
                } else {
                    sum -= cur;
                }
            }
        }
        return sum;
    }
    private Map<Character, Integer> buildMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
}
