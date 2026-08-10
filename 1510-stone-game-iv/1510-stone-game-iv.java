class Solution {

    public boolean solve(int n, Boolean[] dp) {

        if (n == 0) {
            return false;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        for (int k = 1; k * k <= n; k++) {
            if (!solve(n - k * k, dp)) {
                return dp[n] = true;
            }
        }

        return dp[n] = false;
    }

    public boolean winnerSquareGame(int n) {
        Boolean[] dp = new Boolean[n + 1];
        return solve(n, dp);
    }
}