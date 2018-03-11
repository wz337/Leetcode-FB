//do we return all unique combination?
//Time: O(2^n), Space: O(n)
//Key point: Only one copy of duplicates can show up under same parents.
//
/*           ""
          /      \
a       a        {}
b      / \       / \
     ab   |
    /\ \  |
b abb | | |
          a0bc
        a1bc
    a2bc
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }
        //Make sure the array is sorted so we can dedup
        Arrays.sort(nums);  //remember to sort the array please...how else do you know if there are duplicates
        List<Integer> cur = new ArrayList<>();
        helper(0, nums, cur, result);
        return result;
    }
    private void helper(int index, int[] nums, List<Integer> cur, List<List<Integer>> result) {
        if (nums.length == index) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(nums[index]);
        helper(index + 1, nums, cur, result);
        cur.remove(cur.size() - 1);
        //skip all the consecutive and duplicates number
        while (index + 1 < nums.length && nums[index + 1] == nums[index]) {
            index++;
        }
        helper(index + 1, nums, cur, result);
    }
}
