class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if(n==1){
            return 1;
        }

        int minIdx = 0;
        int maxIdx = 0;
        int minValue = nums[0];
        int maxValue = nums[0];

        for(int i=0 ; i<n ; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
                maxIdx = i;
            }
            else if(nums [i] < minValue){
                minValue = nums[i];
                minIdx = i;
            }
        }

        int left = Math.min(minIdx , maxIdx);
        int right = Math.max(minIdx , maxIdx);

        int fromFront = right + 1;
        int fromBack = n- left;
        int fromBoth = (left+1) + (n-right);

        return Math.min(fromFront , Math.min(fromBack , fromBoth));
        
    }
}