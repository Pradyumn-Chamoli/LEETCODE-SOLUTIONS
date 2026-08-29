class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;

        int[] vis = nums.clone();
        Arrays.sort(vis);

        int groupNum = 0;

        HashMap<Integer , Integer> numToGroup = new HashMap<>();
        HashMap<Integer , Deque<Integer>> groupToList = new HashMap<>();

        numToGroup.put(vis[0] , groupNum);

        groupToList.put(groupNum , new ArrayDeque<>());
        groupToList.get(groupNum).addLast(vis[0]);

        for(int i=1 ; i<n ; i++){

            if(vis[i] - vis[i-1] > limit){
                groupNum++;
            }

            numToGroup.put(vis[i], groupNum);

            groupToList.putIfAbsent(groupNum , new ArrayDeque<>());
            groupToList.get(groupNum).addLast(vis[i]);
        }

        int []result = new int[n];

        for(int i=0 ; i<n ; i++){
            int num = nums[i];

            int group = numToGroup.get(num);

            result[i] = groupToList.get(group).pollFirst();

        }

        return result;

        
    }
}