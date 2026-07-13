class Solution {
    public boolean isValid(String str) {
        Stack <Character> st = new Stack<>();
        int n = str.length();
        for(int i=0 ; i<n ; i++){
            if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{'){
                st.push(str.charAt(i));
            }
            else{
                if(st.empty()){
                    return false;
                }
                char ch = st.peek();
                st.pop();

                if((str.charAt(i)==')'&& ch!='(' ) || (str.charAt(i)==']'&& ch!='[' ) || (str.charAt(i)=='}'&& ch!='{' ) ){

                    return false;
                }
            }
        }

        return st.empty();
        
    }
}