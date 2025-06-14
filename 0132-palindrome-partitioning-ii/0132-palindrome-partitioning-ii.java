class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int minCut = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPal[j+1][i-1])) {
                    isPal[j][i] = true;
                    minCut = (j == 0) ? 0 : Math.min(minCut, dp[j-1] + 1);
                }
            }
            dp[i] = minCut;
        }

        return dp[n - 1];
    }
}
