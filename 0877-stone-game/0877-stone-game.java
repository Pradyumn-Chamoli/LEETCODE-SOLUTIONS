class Solution {
    public int solve(int[] piles , int i , int j , int[][]dp){
        if(i>j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int takeLeft = piles[i] + Math.min(solve(piles , i+2 , j ,dp) , solve(piles , i+1 , j-1 , dp));
        int takeRight = piles[j]+Math.min(solve(piles , i , j-2 ,dp ) , solve(piles , i+1 , j-1 ,dp));

        return dp[i][j] = Math.max(takeLeft , takeRight);
    }
    public boolean stoneGame(int[] piles) {
        int n= piles.length;
        int[][] dp = new int[n][n];

        for(int i=0 ; i<n ; i++){
            Arrays.fill(dp[i] , -1);
        }

        int total = 0;
        for(int count : piles){
            total +=count;
        }

        int AliceScore = solve(piles, 0 , n-1,dp);

        return AliceScore > total/2;
    }
}