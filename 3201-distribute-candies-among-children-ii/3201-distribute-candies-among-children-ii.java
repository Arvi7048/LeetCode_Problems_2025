class Solution {
    public long distributeCandies(int n, int limit) {
        return countWays(n, limit);
    }

    private long countWays(int n, int limit) {
        return comb(n, 0)
             - 3 * comb(n, limit + 1)
             + 3 * comb(n, 2 * (limit + 1))
             - comb(n, 3 * (limit + 1));
    }

    // Helper function for combinations (n + 2 choose 2)
    private long comb(int n, int over) {
        long x = n - over;
        if (x < 0) return 0;
        return (x + 2) * (x + 1) / 2;
    }
}
