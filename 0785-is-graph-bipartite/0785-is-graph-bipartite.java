class Solution {

    private boolean bfs(int start , int[]color , List<List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while(!q.isEmpty()){
            int node = q.poll();

            for(int it : adj.get(node)){
                if(color[it]==-1){
                    color[it] = 1-color[node];
                    q.add(it);
                }
                else if(color[it]==color[node]){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        Arrays.fill(color , -1);

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<v ; i++){
            adj.add(new ArrayList<>());

            for(int neighbour : graph[i]){
                adj.get(i).add(neighbour);
            }
        }

        for(int i=0 ; i<v ; i++){
            if(color[i]==-1){
                if(!bfs(i , color , adj )){
                    return false;
                }
            }
        }

        return true;

        
    }
}