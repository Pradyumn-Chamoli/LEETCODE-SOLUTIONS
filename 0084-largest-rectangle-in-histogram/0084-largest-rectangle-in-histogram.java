class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0 ;
        Stack<Integer> st = new Stack<>();

        int n = heights.length;

        for(int i=0 ; i<n ; i++){
            while(!st.empty() && heights[st.peek()] > heights[i]){
                int element = heights[st.pop()];
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();
                int area = element* (nse-pse-1);
                maxArea = Math.max(maxArea ,area );
            }

            st.push(i);
        }

        while(!st.empty()){
            int nse = n;
            int element = heights[st.pop()];
            int pse = st.empty() ? -1 : st.peek();
            int area = element * (nse-pse-1);
            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
       
    }
}
