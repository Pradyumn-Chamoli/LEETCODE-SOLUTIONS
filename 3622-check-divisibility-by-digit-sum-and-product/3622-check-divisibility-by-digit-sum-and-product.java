class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int original = n;

        while(n!=0){
            int digit = n%10;
            sum = sum + digit;
            product = product * digit;
            n = n/10;
        }

        int totalSum = sum+product;

        if(original%totalSum==0){
            return true;
        }

        return false;
        
    }
}