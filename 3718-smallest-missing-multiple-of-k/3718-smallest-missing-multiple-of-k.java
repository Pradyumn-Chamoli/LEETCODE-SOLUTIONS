class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i=0 ; i<nums.length ; i++){
            set.add(nums[i]);
        }

        int multiple = 0;

        for(int i=1 ; i<=101 ; i++){
            int num = k*i;
            if(!set.contains(num)){
                multiple = num;
                break;
            }
        }

        return multiple;


        

    }
}