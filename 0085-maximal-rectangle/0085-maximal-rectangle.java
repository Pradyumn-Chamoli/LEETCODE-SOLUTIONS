
class Solution {

    private int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {

                int height = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                int width = nse - pse - 1;
                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while (!st.isEmpty()) {

            int height = heights[st.pop()];
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            int width = nse - pse - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {

        if (matrix == null || matrix.length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }

            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}