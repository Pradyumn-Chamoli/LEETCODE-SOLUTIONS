class Pair {
    int first;
    int second;
    int third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {

    int[] nextRow = { -1, 0, 1, 0 };
    int[] nextCol = { 0, 1, 0, -1 };

    boolean isValid(int row, int col, int n, int m) {
        if (row < 0 || row >= n)
            return false;
        if (col < 0 || col >= m)
            return false;

        return true;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.first, b.first));

        pq.add(new Pair(grid[0][0], 0, 0));

        while (!pq.isEmpty()) {
            Pair it = pq.poll();
            int time = it.first;
            int row = it.second;
            int col = it.third;

            if(row == n-1 && col == m-1){
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + nextRow[i];
                int newCol = col + nextCol[i];

                if (isValid(newRow, newCol, n, m)) {

                    int newTime = Math.max(time, grid[newRow][newCol]);

                    if (newTime < dist[newRow][newCol]) {
                        dist[newRow][newCol] = newTime;
                        pq.add(new Pair(newTime, newRow, newCol));
                    }
                }
            }

        }

        return -1;
    }
}