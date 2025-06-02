import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k--;  // Convert k to zero-based index
        StringBuilder result = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            if (i > 1)
                k %= fact;
            fact /= (i - 1 == 0) ? 1 : (i - 1);
        }

        return result.toString();
    }

    // Example test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getPermutation(3, 3)); // Output: "213"
    }
}
