class Solution {
    public int countPaths(int n, int[][] roads) {

        int MOD = 1000000007;

        List<int[]> []graph = new ArrayList[n];

        for(int i=0 ; i<n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int [] road : roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            graph[u].add(new int[]{v , wt});
            graph[v].add(new int[]{u , wt});
        }

        long[] shortest = new long[n];
        Arrays.fill(shortest , Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a->a[0]));

        shortest[0] = 0;
        ways[0] = 1;

        pq.add(new long[]{0 , 0});

        while(!pq.isEmpty()){
            long [] curr = pq.poll();
            long dist = curr[0];
            int node = (int) curr[1];

            if(dist > shortest[node]){
                continue;
            }

            for(int[] edge : graph[node]){
                int next = edge[0];
                int weight = edge[1];

                long newDist = dist + weight;

                if(newDist < shortest[next]){
                    shortest[next] = newDist;
                    ways[next] = ways[node];

                    pq.add(new long[]{newDist , next});
                }

                else if(newDist == shortest[next]){
                    ways[next] = (ways[next]+ ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n-1];
    }
}
