class Solution {
    public int[] searchRange(int[] nums, int x) {
       int[] arr = new int[]{-1, -1}; // Proper array initialization
        int n = nums.length;

        if (n == 0) { // Edge case: empty array
            return arr;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                arr[0] = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == x) {
                arr[1] = i;
                break;
            }
        }
        return arr;
    }
}