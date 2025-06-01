import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0 || nums == null || nums.length < 2)
            return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long curr = (long) nums[i];

            // Check for floor and ceiling within the range
            Long floor = set.floor(curr + t);
            Long ceil = set.ceiling(curr - t);

            if ((floor != null && floor >= curr) || (ceil != null && ceil <= curr))
                return true;

            set.add(curr);

            // Maintain the window size of k
            if (i >= k)
                set.remove((long) nums[i - k]);
        }

        return false;
    }
}
