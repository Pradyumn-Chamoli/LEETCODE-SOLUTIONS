class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for(int i=0 ; i<n ; i++){
        int max =Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
            for(int j=0 ; j<=i ; j++){
                max = Math.max(max , nums[j]);
            }
            for(int l=i ; l<n ; l++){
                min = Math.min(min , nums[l]);
            }

            if(max - min <= k){
                return i;
            }

        }

        return -1;
        
    }
}