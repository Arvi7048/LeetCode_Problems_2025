class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findIndex(nums, target, true);
        int last = findIndex(nums, target, false);
        return new int[] {first, last};
    }

    private int findIndex(int[] nums, int target, boolean findFirst) {
        int low = 0, high = nums.length - 1;
        int index = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                index = mid;
                if (findFirst) {
                    high = mid - 1; // Keep searching on left side
                } else {
                    low = mid + 1; // Keep searching on right side
                }
            }
        }

        return index;
    }
}
