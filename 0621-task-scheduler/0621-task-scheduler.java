class Solution {
    public int leastInterval(char[] tasks, int n) {
        int [] freq  = new int[26];

        for(char ch : tasks){
            freq[ch-'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f :freq){
            if(f>0){
                pq.offer(f);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){

            int executed =0;

            List<Integer> temp = new ArrayList<>();

            for(int i=1 ; i<=n+1 ; i++){
                if(!pq.isEmpty()){
                    int f = pq.poll();
                    executed++;
                    f--;

                    if(f>0){
                        temp.add(f);
                    }
                }
            }

            for(int f : temp){
                pq.offer(f);
            }

            if(pq.isEmpty()){
                time +=executed;
            }
            else{
                time +=n+1;
            }
        }

        return time;
        
    }
}