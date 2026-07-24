class Solution {
    public int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        int MAX = 2048;

        boolean [] pair = new boolean[MAX];
        boolean [] ans = new boolean[MAX];

        for(int i=0 ; i<n ; i++){
            for(int j=i ; j<n ; j++){
                pair[nums[i]^nums[j]]=true;
            }
        }

        for(int x=0 ; x<MAX ; x++){
            if(pair[x]){
                for(int num : nums){
                    ans[x^num]=true;
                }
            }
        }

        int count =0;
        for(boolean value : ans){
            if(value){
                count++;
            }
        }
        return count;
    }
}