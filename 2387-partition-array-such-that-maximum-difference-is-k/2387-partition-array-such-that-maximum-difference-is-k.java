import java.util.*;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums); // Sort for greedy grouping
        int count = 0;
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int min = nums[i];
            count++;
            i++;

            // Group all elements within k difference
            while (i < n && nums[i] - min <= k) {
                i++;
            }
        }

        return count;
    }
}
