class Solution {
        private int[] findNge(int [] arr){
        int n = arr.length;

        int []ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1 ; i>=0 ; i--){
            while(!st.empty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }

            ans[i] = !st.empty() ? st.peek() : n;

            st.push(i);
        }

        return ans;
    }

    private int[] findPgee(int [] arr){
        int n = arr.length;

        int []ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){
            while(!st.empty() && arr[st.peek()]<arr[i]){
                st.pop();
            }

            ans[i] = !st.empty() ? st.peek() : -1;

            st.push(i);
        }

        return ans;
    }


    private int[] findNse(int [] arr){
        int n = arr.length;

        int []ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1 ; i>=0 ; i--){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            ans[i] = !st.empty() ? st.peek() : n;

            st.push(i);
        }

        return ans;
    }

    private int[] findPsee(int [] arr){
        int n = arr.length;

        int []ans = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){
            while(!st.empty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            ans[i] = !st.empty() ? st.peek() : -1;

            st.push(i);
        }

        return ans;
    }

    
    private long sumSubarrayMin(int [] nums){
        int[] nse = findNse(nums);
        int [] psee = findPsee(nums);

        long sum = 0;

        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            int left = i-psee[i];
            int right = nse[i] - i;

            long freq = left*right*1L;
            long val = (freq*nums[i] *1L);

            sum+=val;
        }
        return sum;
    }

    private long sumSubarrayMax(int [] nums){
        int[] nge = findNge(nums);
        int [] pgee = findPgee(nums);

        long sum = 0;

        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            int left = i-pgee[i];
            int right = nge[i] - i;

            long freq = left*right*1L;
            long val = (freq*nums[i] *1L);

            sum+=val;
        }
        return sum;
    }


    public long subArrayRanges(int[] nums) {
        return  (sumSubarrayMax(nums) - sumSubarrayMin(nums));
     
    }
}