class Solution {
    public int maximumLengthSubstring(String s) {
        int left=0;
        int maxlen=0;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int right=0; right<s.length() ; right++){
            char ch =s.charAt(right);

            freq.put(ch , freq.getOrDefault(ch,0)+1);
            while(freq.get(ch)>2){
                char leftchar=s.charAt(left);
                freq.put(leftchar,freq.get(leftchar)-1);
                left++;
            }

            maxlen = Math.max(maxlen,right-left+1);
        }

        return maxlen;
        
    }
}