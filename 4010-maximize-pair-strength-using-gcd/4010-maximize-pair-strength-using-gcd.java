class Solution {
    public long gcd(int a , int b){
        while(b!=0){
            int res = a%b;
            a= b;
            b = res;
        }

        return (long) a;
    }
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long max = Long.MIN_VALUE;



        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n-1 ; j++){

                long res = ((long)nums[i]*(long)nums[j])/(gcd(nums[i] , nums[j]) * gcd(nums[i] , nums[j]));
                max = Math.max(res,max);
            }
        }
        return max;
    }
}