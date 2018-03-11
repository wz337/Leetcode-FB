/*
Given [3,2,1,5,6,4] and k = 2, return 5.
先讨论 heap和 quick select的解法和复杂度 实现 quickselect的解法

maxHeap: O(nlgk)
minHeap: O(k) + O(n-k)(lgk)
quickselect: O(n) as each time we discard half O(n/2) + O(n/4) + O(n/8) ... = O(n)
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);
            if (minHeap.size() > k) { //
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
//     public int findKthLargest(int[] nums, int k) {
//         if (nums == null || nums.length - k < 0) {
//             return 0;
//         }
//         int target = nums.length - k; //the 2nd largest in 6, after ordering it will be the fourth one in the array
//         quickSelect(nums, 0, nums.length - 1, target);
//         return nums[target];
//     }
    
//     private void quickSelect(int[] nums, int left, int right, int target) {
//         int partition = partition(nums, left, right);
//         if (partition == target) {
//             return;
//         } else if (partition < target) {
//             quickSelect(nums, partition + 1, right, target);
//         } else {
//             quickSelect(nums, left, partition - 1, target);
//         }
//     }
    
//     private int partition(int[] nums, int left, int right) {
//         int pivot = nums[right];
//         int pivotPos = right;
        
//         int i = left;
//         int j = right - 1;
//         while (i <= j) {
//             if (nums[i] < pivot) {
//                 i++;
//             } else if (nums[j] >= pivot) {
//                 j--;
//             } else {
//                 swap(nums, i++, j--);
//             }
//         }
        
//         swap(nums, i, pivotPos);
//         return i;
//     }
    
//     private void swap(int[] nums, int left, int right) {
//         int temp = nums[left];
//         nums[left] = nums[right];
//         nums[right] = temp;
//     }
}
