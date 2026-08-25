class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){

                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }

                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int []row  = {-1 , 0 , 1 , 0};
        int []col = {0 , 1 , 0 , -1 };

        while(!q.isEmpty() && fresh>0){

            int size = q.size();

            while(size-- > 0){
                int []curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int i=0 ; i<4 ; i++){
                    int newRow = r + row[i];
                    int newCol = c + col[i];

                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol]==1){
                        grid[newRow][newCol] = 2;
                        fresh--;
                        q.add(new int[]{newRow , newCol});
                    }
                }
            }

            time++; 
        }

        return fresh==0?time : -1;

        
     
    }
}


