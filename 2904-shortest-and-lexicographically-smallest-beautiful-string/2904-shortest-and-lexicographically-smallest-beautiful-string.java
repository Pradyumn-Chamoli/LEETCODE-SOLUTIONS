class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int l = 0;
        int r =0;
        int ones = 0;

        String ans = "";

        for( r=0 ; r<s.length() ; r++){
            if(s.charAt(r)=='1'){
                ones++;
            }

            while(ones>k){
                if(s.charAt(l)=='1'){
                    ones--;
                }
                l++;
            }

            if(ones==k){
                while(s.charAt(l)=='0'){
                    l++;
                }

                String current = s.substring(l , r+1);

                if(ans.equals("")||current.length()<ans.length() || (current.length()==ans.length() && current.compareTo(ans)<0)){
                    ans = current;
                }
            }
        }

        return ans;

        
    }
}