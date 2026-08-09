class Solution {
    int n;
    int[][][] t = new int[2][101][101];

    int solveForAlice(int[] piles , int person , int i , int m){
        if(i>=n){
            return 0;
        }

        if(t[person][i][m]!=-1){
            return t[person][i][m];
        }

        int stones = 0;

        int result = (person==1) ? -1 : Integer.MAX_VALUE;

        for(int x = 1 ; x<=Math.min(2*m , n-i) ; x++){
            stones += piles[i+x-1];

            if(person==1){
            result = Math.max(result , stones+solveForAlice(piles , 0 , i+x , Math.max(m,x)));
            }

            else{
                result = Math.min(result , solveForAlice(piles , 1 , i+x , Math.max(m,x)));
            }
        }

        return t[person][i][m] = result;
    }
    public int stoneGameII(int[] piles) {

         n = piles.length;

        for(int person =0 ; person<2 ; person++){
            for(int i=0 ; i<101 ; i++){
                Arrays.fill(t[person][i] , -1);
            }
        }

        return solveForAlice(piles , 1, 0 ,1);
        
    }
}