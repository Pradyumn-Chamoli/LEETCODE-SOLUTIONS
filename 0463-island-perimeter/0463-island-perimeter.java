class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int []r = {-1,0,1,0};
        int []c = {0,1,0,-1};

        for(int i=0 ; i<grid.length ; i++){
            for(int j=0 ; j<grid[0].length ; j++){

                if(grid[i][j]==1){

                for(int k=0 ; k<4 ; k++){
                    int newRow = i+r[k];
                    int newCol = j+c[k];
                    if(newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length || grid[newRow][newCol]==0){
                        perimeter++;
                    }
                }

                }
            }
        }

        return perimeter;
        
    }
}