class Solution {

    public int bfs(int r , int c , int[][] grid , boolean[][]vis , int k){
        int [] row = {-1 ,0 ,1 ,0};
        int [] col = {0, -1 , 0 , 1};

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{r , c});
        vis[r][c] = true;

        long sum = 0;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            sum = sum + grid[currRow][currCol];

            for(int i=0 ; i<4 ; i++){
                int newRow = currRow + row[i];
                int newCol = currCol + col[i];

                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && !vis[newRow][newCol] && grid[newRow][newCol] >0){
                    vis[newRow][newCol] = true;
                    q.add(new int[]{newRow , newCol});
                }

            }
        }

        if(sum % k==0){
            return 1;
        }

        return 0;

    }
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][]vis = new boolean[n][m];
        int count = 0 ;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(grid[i][j]>0 && !vis[i][j]){
                    count += bfs(i , j , grid , vis , k);
                }
            }
        }

        return count;
        
    }
}