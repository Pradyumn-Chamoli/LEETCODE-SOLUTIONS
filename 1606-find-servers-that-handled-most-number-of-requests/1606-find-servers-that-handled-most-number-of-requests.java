class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> availableServer = new TreeSet<>();

        for(int i=0 ; i<k ; i++){
            availableServer.add(i);
        }

        PriorityQueue<long[]> busyServer = new PriorityQueue<>(
            (a,b)->{
                if(a[0]!=b[0]){
                    return Long.compare(a[0],b[0]);
                }
                return Long.compare(a[1],b[1]);
            }
        );

        int []countReq = new int[k];

        for(int i=0 ; i<arrival.length ; i++){

            int time = arrival[i];

            while(!busyServer.isEmpty() && busyServer.peek()[0]<=time){

                int server = (int)busyServer.poll()[1];

                availableServer.add(server);
            }

            if(availableServer.isEmpty()){
                continue;
            }

            int target = i%k;

            Integer targetServer = availableServer.ceiling(target);

            if(targetServer == null){
                targetServer = availableServer.first();
            }

            availableServer.remove(targetServer);

            busyServer.offer(new long[]{
                (long) time + load[i],
                targetServer
            });

            countReq[targetServer]++;
        }

        int maxReq = 0;

        for(int count : countReq){
            maxReq = Math.max(count , maxReq);
        }

        List<Integer> maxCount = new ArrayList<>();

        for(int i=0 ; i<k ; i++){
            if(countReq[i] == maxReq){
                maxCount.add(i);
            }
        }

        return maxCount;
        
    }
}