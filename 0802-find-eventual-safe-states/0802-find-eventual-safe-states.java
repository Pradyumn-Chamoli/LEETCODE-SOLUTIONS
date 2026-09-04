class Solution {
    private boolean dfs(int node , int[]vis , int[]pathVis , int[]check , int[][]adj){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for(int it : adj[node]){
            if(vis[it]==0){
                if(dfs(it , vis , pathVis , check , adj)){
                return true;
                }
            }
            else if(pathVis[it]==1){
                return true;
            }
        }

        pathVis[node]=0;
        check[node] = 1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) { 
        int V = graph.length;
        int []vis = new int[V];
        int[] pathVis = new int[V];
        int []check = new int[V];

        for(int i=0 ; i<V ;i++){
            if(vis[i]==0){
                dfs(i , vis , pathVis , check , graph);
            }
        }

        List<Integer> temp = new ArrayList<>();
        for(int i=0 ; i<V ; i++){
            if(check[i]==1){
                temp.add(i);
            }
        }

        return temp;

       
    }
}
