class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long maxSum = 0;
        long minSum  = 0;
        
        for(int i=0 ; i<n ; i++){
            nums[i] = nums[i]*nums[i];
        }

        Arrays.sort(nums);

        for(int i=0 ; i<n/2 ; i++){
            minSum += nums[i] ;
        }

        for(int i=n/2 ; i<n ; i++){
            maxSum += nums[i] ;
        }

        return maxSum - minSum;

        
    }
}