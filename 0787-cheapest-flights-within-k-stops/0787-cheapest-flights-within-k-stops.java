class Graph {
    int u;
    int wt;

    Graph(int u, int wt) {
        this.u = u;
        this.wt = wt;
    }
}

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

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if (src == dst) {
            return 0;
        }

        List<List<Graph>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(
                new Graph(flight[1], flight[2])
            );
        }

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(0, src, 0));

        while (!q.isEmpty()) {

            Pair it = q.poll();

            int stops = it.first;
            int node = it.second;
            int dist = it.third;

            if (stops > k) {
                continue;
            }

            for (Graph neighbour : adj.get(node)) {

                int adjNode = neighbour.u;
                int weight = neighbour.wt;

                if (dist + weight < minDist[adjNode]) {

                    minDist[adjNode] = dist + weight;

                    q.add(
                        new Pair(
                            stops + 1,
                            adjNode,
                            dist + weight
                        )
                    );
                }
            }
        }

        if (minDist[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return minDist[dst];
    }
}