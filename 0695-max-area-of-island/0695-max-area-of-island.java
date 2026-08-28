class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         int maxArea = 0;

        boolean[][] vis = new boolean[n][m];

        for(int i=0 ;i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(grid[i][j]==1 && !vis[i][j]){
                    vis[i][j]=true;
                    int area = 0;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});

                    int []r = {-1,0,1,0};
                    int []c = {0,1,0,-1};

                    while(!q.isEmpty()){
                        int curr[] = q.poll();
                        area++;
                        
                        for(int k=0 ; k<4 ; k++){
                            int newRow = curr[0] + r[k];
                            int newCol = curr[1] + c[k];

                            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]==1 && !vis[newRow][newCol]){
                                vis[newRow][newCol]=true;
                                q.add(new int[]{newRow , newCol});
                            }
                        }
                    }

                    maxArea = Math.max(maxArea , area);
                   
                }
            }
        }


        return maxArea;

        
    }
}