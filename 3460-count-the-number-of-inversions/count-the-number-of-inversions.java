import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {
        // Map prefix length - required inversion count
        int[] req = new int[n + 1];
        Arrays.fill(req, -1);
        for (int[] r : requirements) {
            req[r[0] + 1] = r[1]; // requirement applies to prefix of length end+1
        }

        // dp[len][inv] = number of permutations of length len with exactly inv inversions
        int[][] dp = new int[n + 1][401]; 
        dp[0][0] = 1;

        for (int len = 1; len <= n; len++) {
            for (int inv = 0; inv <= 400; inv++) {
                long ways = 0;
                // Adding new element at different positions - creates k new inversions
                for (int k = 0; k < len; k++) {
                    if (inv - k >= 0) {
                        ways += dp[len - 1][inv - k];
                    }
                }
                dp[len][inv] = (int)(ways % MOD);
            }

            // Apply requirement constraint if exists
            if (req[len] != -1) {
                int required = req[len];
                for (int inv = 0; inv <= 400; inv++) {
                    if (inv != required) {
                        dp[len][inv] = 0;
                    }
                }
            }
        }

        // Final requirement must be at full length
        int finalReq = req[n];
        return finalReq == -1 ? 0 : dp[n][finalReq];
    }
}
