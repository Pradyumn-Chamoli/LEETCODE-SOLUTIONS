class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer>  ans = new ArrayList<>();

        for(int i=1 ; i<n ; i++){
            for(int j = nums[i-1]+1 ; j<nums[i] ; j++){
                ans.add(j);
            }
        }

        return ans;
        
    }
}