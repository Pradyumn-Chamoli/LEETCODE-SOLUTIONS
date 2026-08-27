class Solution {

    private void bfs(int row , int col , char[][]board , boolean[][]vis){
        int n = board.length;
        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row , col});
        vis[row][col] = true;

        int [] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int [] curr = q.poll();

            for(int i=0 ; i<4 ; i++){
                int r = curr[0] + dr[i];
                int c = curr[1] + dc[i];

                if(r>=0 && r<n && c>=0 && c<m && board[r][c]=='O' && !vis[r][c]){
                    q.add(new int[]{r,c});
                    vis[r][c] = true;
                }
            }
        }
    }
    public char[][] solve(char[][] board) {
        int n  = board.length;
        int m = board[0].length;

        boolean [][] vis = new boolean[n][m];

        for(int j=0 ; j<m ; j++){
            if(board[0][j]=='O' && !vis[0][j]){
                bfs(0 , j , board , vis);
            }
            
            if(board[n-1][j]=='O' && !vis[n-1][j]){
                bfs(n-1 , j , board , vis);
            }
        }

        for(int i=0 ; i<n ; i++){
            if(board[i][0]=='O' && !vis[i][0]){
                bfs(i,0,board,vis);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                bfs(i,m-1,board,vis);
            }
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<m ; j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }

        return board;
        
    }
}