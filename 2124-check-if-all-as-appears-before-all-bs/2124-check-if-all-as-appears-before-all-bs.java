class Solution {
    public boolean checkString(String s) {
        int n = s.length();
        int bidx = -1;
        int aidx = -1;

        for(int i=0 ; i<n ; i++){
            if(s.charAt(i)=='b'){
                bidx=i;
                break;
            }
        }

        for(int i=0 ; i<n ; i++){
            if(s.charAt(i)=='a'){
                aidx=i;
            }
        }

        if(bidx==-1 && aidx>-1){
            return true;
        }

        return bidx>aidx ? true : false;
        
    }
}