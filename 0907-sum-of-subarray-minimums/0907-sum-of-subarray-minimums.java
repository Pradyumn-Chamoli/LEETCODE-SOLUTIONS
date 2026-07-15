class Solution {

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
    public int sumSubarrayMins(int[] arr) {
        int []nse = findNse(arr);
        int []psee = findPsee(arr);

        int sum = 0 ;
        int mod = (int)1e9 + 7;

        int n = arr.length;

        for(int i=0 ; i<n ; i++){

            //left ke andar voh number of left side subarrays honge jisme ith element sabse chota hoga
            int left = i - psee[i];

            //right ke andar voh number of right side subarray honge jisme ith element sabse chota hoga 
            int right = nse[i] - i;

            //calculate karo number of subarrays jisme yeh ith element chota ho
            long freq = left * right * 1L;
            
            //voh value * jitne number of subarrays mae voh aarahi hai
            int val = (int)(freq*arr[i] %mod);

            sum = (sum + val)%mod;
        }

        return sum;
   
    }
}
