class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] fact, invFact;

    public int countGoodArrays(int n, int m, int k) {
        initFactorials(n);
        // Choose k matching positions from n-1 adjacent pairs
        long c = fact[n - 1] * invFact[k] % MOD * invFact[n - 1 - k] % MOD;
        // First group: m choices; remaining n-k-1 groups: (m-1) options each
        long ways = m * modPow(m - 1, n - 1 - k) % MOD;
        return (int)(c * ways % MOD);
    }

    private void initFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; ++i) fact[i] = fact[i - 1] * i % MOD;
        invFact[n] = modPow(fact[n], MOD - 2);
        for (int i = n; i > 0; --i) 
            invFact[i - 1] = invFact[i] * i % MOD;
    }

    private long modPow(long x, long p) {
        long res = 1;
        x %= MOD;
        while (p > 0) {
            if ((p & 1) == 1) res = res * x % MOD;
            x = x * x % MOD;
            p >>= 1;
        }
        return res;
    }
}
