import java.util.*;

public class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {
        // 1. Count how many points lie on each y-coordinate
        Map<Long, Integer> countByY = new HashMap<>();
        for (int[] p : points) {
            long y = p[1]; // y-coordinate
            countByY.put(y, countByY.getOrDefault(y, 0) + 1);
        }

        // 2. Compute C(c, 2) for each y where c >= 2
        List<Long> waysList = new ArrayList<>();
        for (int c : countByY.values()) {
            if (c >= 2) {
                long cc = c;
                long ways = cc * (cc - 1) / 2 % MOD;
                waysList.add(ways);
            }
        }

        // If fewer than 2 y-levels have at least 2 points, no trapezoid is possible
        if (waysList.size() < 2) return 0;

        // 3. Sum over all pairs: answer = sum_{i<j} ways[i] * ways[j]
        long prefix = 0;
        long answer = 0;
        for (long ways : waysList) {
            answer = (answer + prefix * ways) % MOD;
            prefix = (prefix + ways) % MOD;
        }

        return (int) answer;
    }
}
