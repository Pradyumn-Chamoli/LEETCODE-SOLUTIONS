class Solution {
    public int solve(int[] stoneValue , int i , int[]dp){
        int n = stoneValue.length;
        int result = Integer.MIN_VALUE;

        if(i>=n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        result = stoneValue[i] - solve(stoneValue , i+1 , dp);

        if(i+1<n){
        result = Math.max(result , stoneValue[i] + stoneValue[i+1] - solve(stoneValue , i+2 , dp));
        }

        if(i+2<n){
            result = Math.max(result , stoneValue[i] + stoneValue[i+1] + stoneValue[i+2] - solve(stoneValue , i+3 , dp));
        }

        return dp[i] = result;
        
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int [] dp = new int[n+1];

        Arrays.fill(dp , -1);

        int result = solve(stoneValue , 0 , dp);

        if(result > 0){
            return "Alice";
        }
        else if(result < 0){
            return "Bob";
        }

        return "Tie";
        
    }
}