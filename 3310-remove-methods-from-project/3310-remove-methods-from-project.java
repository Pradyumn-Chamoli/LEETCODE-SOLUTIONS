class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0 ; i<n ; i++){
            adj.add(new ArrayList<>());
        }

        int [] indegree = new int[n];
        boolean []suspicious = new boolean[n];

        for(int []edge : invocations){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);

            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(k);

        suspicious[k]=true;

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int nb : adj.get(curr)){
                indegree[nb]--;

                if(!suspicious[nb]){
                    suspicious[nb] = true;
                    queue.offer(nb);
                }
            }
        }

        boolean cannotRemove = false;

        for(int i=0 ; i<n ; i++){
            if(suspicious[i] && indegree[i]>0){
                cannotRemove = true;
                break;
            }
        }

        if(cannotRemove){
            List<Integer> ans = new ArrayList<>();
            for(int i=0 ; i<n ; i++){
                ans.add(i);
            }

            return ans;
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<n ; i++){
            if(!suspicious[i]){
                result.add(i);
            }
        }


        return result;




        
    }
}