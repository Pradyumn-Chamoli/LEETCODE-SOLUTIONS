class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen = Integer.MIN_VALUE;
        for(int light : lights){
            maxGreen = Math.max(maxGreen , light);
        }

        int waiting = Integer.MIN_VALUE;

        for(int i=0 ; i<arrivalTime.length ; i++){
            int r = arrivalTime[i]%period;


            if(r<maxGreen){
                waiting = Math.max(waiting , 0);
            }
            else{
                waiting = Math.max(waiting , period - r);
            }
        }

        return waiting;
        
    }
}