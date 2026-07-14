class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2 = nums2.length;
        int n1 = nums1.length;
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=n2-1 ; i>=0 ; i--){
            while(!st.empty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.empty()){
                map.put(nums2[i] , -1);
            }
            else{
                map.put(nums2[i] , st.peek());
            }

            st.push(nums2[i]);
        }

        int[] ans = new int[n1];
        for(int i=0 ; i<n1 ; i++){
            ans[i] = map.get(nums1[i]);

        }

        return ans;
        
    }
}