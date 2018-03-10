//Time: O(2^n) n represents the number of elements in nums
//Space: O(n) 
//Level: decides whether to include the current nums[index] in our final solution
//State: to add or not to add the current element
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }
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
        dfs(nums, index + 1, cur, result);
    }
}
