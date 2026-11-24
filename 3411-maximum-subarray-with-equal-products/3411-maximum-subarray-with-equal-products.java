class Solution {

    public long gcd(long a , long b){
        while(b!=0){
            long rem = a%b;
            a = b ;
            b = rem;
        }

        return a;
    }

    public long lcm(long a , long b){
        return (a / gcd(a,b))*b;
    }
    public int maxLength(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0 ; i<n ; i++){
            long prod = 1;
            long g = nums[i];
            long l = 1;
            for(int j=i ; j<n ; j++){
                prod *= nums[j];
                g = gcd (g , nums[j]);
                l = lcm(l , nums[j]);

                if(prod == g * l){
                    max = Math.max(max , j-i+1);
                }

                if(prod > 25200){
                    break;
                }
            }
        }

        return max;
        
    }
}