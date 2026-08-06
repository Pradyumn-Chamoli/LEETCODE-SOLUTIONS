class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n ; i<=100 ; i++){
            int product = 1 ;
            int num = i;
            while(num!=0){
            int digit = num%10;
            product = product * digit;
            num=num/10;
            }
            if(product%t==0){
                return i;
            }
        
        }

        return -1;
        
    }
}