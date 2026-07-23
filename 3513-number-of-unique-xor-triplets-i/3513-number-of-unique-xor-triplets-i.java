class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }

        int bits = Integer.toBinaryString(n).length();

        return 1<<bits;
        
    }
}