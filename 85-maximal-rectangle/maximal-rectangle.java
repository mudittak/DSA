class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] mat = new int[m][n];

        // Convert char matrix to int heights
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                mat[i][j] = matrix[i][j] - '0';
            }
        }

        // Build cumulative heights
        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1) mat[i][j] += mat[i-1][j];
            }
        }

        int max = 0;
        for(int[] row : mat){
            max = Math.max(max, getMaxArea(row));
        }
        return max;
    }

    private int getMaxArea(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] nse = new int[n];
        int[] pse = new int[n];

        // Next Smaller Element
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // Previous Smaller Element
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for(int i=0;i<n;i++){
            int width = nse[i] - pse[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
