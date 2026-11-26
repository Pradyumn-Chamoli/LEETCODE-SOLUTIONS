class Solution {
    public boolean canAliceWin(int n) {
        int stones = 10;
        boolean aliceTurn = true;

        while(stones > 0 && n>=stones){
            n -= stones;
            stones--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}