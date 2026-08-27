class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][]vis = new int[n][m];
        int [][]dist = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new int[]{i,j,0});
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        int []row = {-1,0,1,0};
        int []col = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int step = curr[2];;

            dist[r][c] = step;

            for(int i=0 ; i<4 ; i++){
                int newRow = r + row[i];
                int newCol = c + col[i];

                if(newRow >=0 && newRow <n && newCol>=0 && newCol<m && vis[newRow][newCol]==0){
                    vis[newRow][newCol]=1;
                    q.add(new int[]{newRow , newCol , step+1});
                }
            }
        }

        return dist;
        
    }
}