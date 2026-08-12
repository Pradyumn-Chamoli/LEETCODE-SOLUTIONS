class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i=0 ; 
        int length = 0;
        int n = nums.length;
        HashMap<Integer , Integer > map = new HashMap<>();

        for(int j=0 ; j<n ; j++){
            map.put(nums[j] , map.getOrDefault(nums[j],0)+1);

            while(map.get(nums[j])>k){
                map.put(nums[i] , map.getOrDefault(nums[i],0)-1);
                i++;
            }

            length = Math.max(j-i+1 , length);
        }
        
        return length;
    }
}