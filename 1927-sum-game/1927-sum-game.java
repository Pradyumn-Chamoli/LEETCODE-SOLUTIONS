class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftQuesSum = 0;
        int rightQuesSum = 0;

        int leftNumSum =0;
        int rightNumSum = 0;

        for(int i=0 ; i<n ; i++){
            if(num.charAt(i)=='?'){
                if(i<n/2){
                    leftQuesSum++;
                }
                else{
                    rightQuesSum++;
                }
            }
            else{
                if(i<n/2){
                    leftNumSum += num.charAt(i) - '0';
                }
                else{
                    rightNumSum += num.charAt(i) - '0';
                }
            }
        }

        int totalQues = leftQuesSum + rightQuesSum;

        if(totalQues % 2 ==1){
            return true;
        }

        int left = 2 * leftNumSum + 9 * leftQuesSum;
        int right = 2*rightNumSum + 9* rightQuesSum;

        if(left==right){
            return false;
        }

        return true;
        
    }
}