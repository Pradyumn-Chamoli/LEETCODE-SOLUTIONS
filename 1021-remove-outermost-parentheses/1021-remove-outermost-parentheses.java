class Solution {
    public String removeOuterParentheses(String s) {
        int open = 0 ;
        int close = 0;
        int start = 0;

        StringBuilder ans = new StringBuilder();

        for(int i=0 ;i<s.length() ; i++){
            if(s.charAt(i)=='('){
                open ++;
            }
            else{
                close++;
            }

            if(open==close){
                ans.append(s.substring(start+1 , i));

                start = i + 1;
            }

        }
        

        return ans.toString();
    }
}