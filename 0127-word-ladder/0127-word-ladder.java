class Pair{
    String first;
    int second;

    Pair(String first , int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>();
        for(int i=0 ; i<wordList.size() ; i++){
            st.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        st.remove(beginWord);

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.first;
            int step = curr.second;

            if(word.equals(endWord)==true){
                return step;
            }

            for(int i=0 ; i<word.length() ; i++){
                for(char ch='a' ; ch<='z' ; ch++){
                    char []replacedCharArray = word.toCharArray();
                    replacedCharArray[i]= ch;
                    String replacedChar = new String(replacedCharArray);
                    if(st.contains(replacedChar)==true){
                        st.remove(replacedChar);
                        q.add(new Pair(replacedChar , step+1));
                    }
                }
            }
        }

        return 0;
    
    }
}
