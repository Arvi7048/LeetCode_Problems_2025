class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long to avoid overflow, and work with positives
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;

        // Bitwise division
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                a -= b << i;
                result += 1 << i;
            }
        }

        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }
}
