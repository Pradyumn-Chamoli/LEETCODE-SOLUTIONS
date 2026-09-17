class Pair{
    int first;
    int second;

    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0 ; i<= n ; i++){
            adj.add(new ArrayList<>());
        }

        int m = times.length;

        for(int i=0 ; i<m ; i++){
            adj.get(times[i][0]).add(new Pair(times[i][2] , times[i][1]));
        }

        int [] dist = new int[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.first-b.first);

        Arrays.fill(dist , (int)1e9);

        dist[k] = 0;

        pq.add(new Pair(0,k));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.second;
            int d = curr.first;

            for(Pair neighbour : adj.get(node)){
                int adjNode = neighbour.second;
                int wt = neighbour.first;

                if(d + wt < dist[adjNode]){
                    dist[adjNode] = d + wt;
                    pq.add(new Pair(dist[adjNode] , adjNode));
                }
            }
        }

        int ans = 0;

        for(int i=1 ; i<=n ; i++){
            if(dist[i]==(int)1e9){
                return -1;
            }

            ans = Math.max(ans , dist[i]);
        }

        return ans;

        
    }
}