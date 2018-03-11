//Time: O(n)  n is the length of the brick
//Space: O(n)
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() < 1) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(); //k: edge, v: count
        int max = 0;
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) { //we don't want the very last edge
                length += list.get(i); 
                Integer count = map.get(length);
                if (count == null) {
                    count = 0;
                } 
                map.put(length, count + 1);
                max = Math.max(max, count + 1);
            }
        }
        return wall.size() - max;
    }
}
