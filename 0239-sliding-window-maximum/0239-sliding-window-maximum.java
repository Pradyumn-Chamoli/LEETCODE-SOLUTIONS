class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int ansIdx = 0;

        int [] ans = new int[n-k+1];

        for(int i=0 ; i<n ;i++){

            //yeh condition check karegi ki window ka size k se badha toh nahi hai..
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }


            //jo bhi element current element se chotey hai unko ek ek karke deque ke last se remove karna hai ..kyunki voh element kabhi maximum nahi ban sakhtey..
            while(!dq.isEmpty() && arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }

            dq.offerLast(i);

            //agar deque ke andar k elements hojayenge toh humko first wala element remove karna hai kyunki first element sabse largest hoga us window ke liye...
            if(i>=k-1){
                ans[ansIdx++] = arr[dq.peekFirst()];
            }
        }

        return ans;
    }
}
