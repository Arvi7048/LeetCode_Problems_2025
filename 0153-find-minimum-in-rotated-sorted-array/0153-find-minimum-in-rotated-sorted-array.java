class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum is in the right part
                low = mid + 1;
            } else {
                // Minimum is in the left part including mid
                high = mid;
            }
        }

        return nums[low];
    }
}
