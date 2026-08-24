class Solution {

    private void bfs(int[][]grid , Queue<int[]> q , boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        int[] row = {-1 , 0 , 1 , 0};
        int [] col = {0 , -1 , 0 , 1};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int k=0 ; k<4 ; k++){
                int newRow = r + row[k];
                int newCol = c + col[k];

                if(newRow >=0 && newRow<n && newCol >=0 && newCol<m && grid[newRow][newCol]==1 && !vis[newRow][newCol]){
                    vis[newRow][newCol]= true;
                    q.add(new int[]{newRow , newCol});
                } 
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] vis = new boolean [n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ;j++){

                if((i==0 || i==n-1 || j==0 || j==m-1) && grid[i][j]==1 ){
                    vis[i][j] = true;
                    q.add(new int[]{i , j});
                }
            }
        }

        bfs(grid , q , vis);

        int count=0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(grid[i][j] ==1 && !vis[i][j]){
                    count++;
                }

            }
        }

        return count;
     
    }
}