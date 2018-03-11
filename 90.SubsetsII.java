//Time: O(2^n)
//Space: O(n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        Arrays.sort(nums); //Remember to sort the array to dedup.
        List<Integer> cur = new ArrayList<>();
        dfs(nums, 0, cur, result);
        return result;
    }
    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[index]);
        dfs(nums, index + 1, cur, result);
        cur.remove(cur.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index++;
        }
        dfs(nums, index + 1, cur, result);
    }
}




