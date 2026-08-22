class Solution {

    private void bfs(int node , int[][]adj , boolean[]vis){
        vis[node] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            int curr = q.poll();
            for(int adjNode=0 ; adjNode<adj.length ; adjNode++){
                if(adj[curr][adjNode]==1 && !vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(adjNode);
                }

            }
        }
    }
    public int findCircleNum(int[][] adj) {
        int v = adj.length;
        boolean [] vis = new boolean[v];

        int cnt = 0;

        for(int i=0 ; i<v ; i++){
            if(!vis[i]){

                cnt++;

                bfs(i , adj , vis);

            }
        }

        return cnt;
        
    }
}