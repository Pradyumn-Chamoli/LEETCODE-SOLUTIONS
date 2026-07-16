class Solution {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        int n = nums.length();

        for(int i=0 ; i<n ; i++){
            char digit = nums.charAt(i);

            //agar stack mae koi bada element hai to usko remove karke chota wala daldo
            while(!st.empty() && k>0 && st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }

        //agar k ki value bach rahi hai to last se k element remove kardo..for ex 1234 wala case
        while(!st.empty() && k>0){
            st.pop();
            k--;
        }

        //agar stack puri khali ho gyi toh return 0
        if(st.empty()) return "0";

        StringBuilder res = new StringBuilder();

        while(!st.empty()){
            res.append(st.pop());
        }

        //agar res ke end mae zeros hain toh unko remove kardo
        while(res.length()>0 && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }


        res.reverse();

        //agar string mae sare hi zero honge toh sab remove hojayenge so this is the case to handle that
        if(res.length()==0) return "0";

        return res.toString();
       
    }
}