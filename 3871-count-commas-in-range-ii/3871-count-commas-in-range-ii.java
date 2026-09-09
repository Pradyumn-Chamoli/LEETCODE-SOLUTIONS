class Solution {
    public long countCommas(long n) {
        if(n<=999){
            return 0;
        }

        long start = 1000;
        long comma = 1;
        long ans = 0;

        while(start<=n){
            long end = Math.min((start * 1000 )- 1 , n);
            ans = ans + (end - start + 1)*comma;
            start = end + (long)1;
            comma = comma + (long)1;
        }

        return ans;
        
    }
}