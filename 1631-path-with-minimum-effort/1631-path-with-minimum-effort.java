class Pair{
    int first;
    int second;
    int third;

    Pair(int first  , int second , int third){
        this.first = first ;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    int []diffRow = {-1,0,1,0};
    int []diffCol = {0,1,0,-1};

    boolean isValid(int row , int col , int n , int m){
        if(row<0 || row>=n) return false;
        if(col<0 || col>=m) return false;

        return true;
    }
    public int minimumEffortPath(int[][] heights) {
        int n= heights.length;
        int m = heights[0].length;

        int [][]maxDiff = new int[n][m];

        for(int []rows : maxDiff){
            Arrays.fill(rows , Integer.MAX_VALUE);
        }

        maxDiff[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.first , b.first)
        );

        pq.add(new Pair(0,0,0));

        while(!pq.isEmpty()){
            Pair it =  pq.poll();
            int diff = it.first;
            int row = it.second;
            int col = it.third;

            if(row==n-1 && col ==m-1){
                return diff;
            }

            for(int i=0 ; i<4 ; i++){
                int newRow = row + diffRow[i];
                int newCol = col + diffCol[i];

                if(isValid(newRow , newCol , n , m)){
                    int currDiff = Math.abs(heights[newRow][newCol] - heights[row][col]);

                    int newDiff = Math.max(currDiff , diff);

                    if(newDiff < maxDiff[newRow][newCol]){
                        maxDiff[newRow][newCol] = newDiff;

                        pq.add(new Pair(newDiff , newRow , newCol));
                    }


                }
            }
        }

        return -1;
        
    }
}