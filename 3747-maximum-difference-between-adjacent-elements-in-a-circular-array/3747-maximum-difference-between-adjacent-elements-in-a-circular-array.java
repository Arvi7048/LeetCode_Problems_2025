class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = Math.abs(nums[0] - nums[n - 1]); // circular difference

        for (int i = 1; i < n; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            maxDiff = Math.max(maxDiff, diff);
        }

        return maxDiff;
    }
}
