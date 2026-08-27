class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();

  
        int i = 0;

        while (i < n && freq[target.charAt(i) - 'a'] > 0) {
            char c = target.charAt(i);

            ans.append(c);
            freq[c - 'a']--;

            i++;
        }

       
        for (int j = i; j >= 0; j--) {

          
            if (j < ans.length()) {
                char c = ans.charAt(j);
                freq[c - 'a']++;
                ans.deleteCharAt(j);
            }

        
            if (j < n) {
                for (int c = target.charAt(j) - 'a' + 1; c < 26; c++) {

                    if (freq[c] > 0) {

                        StringBuilder result = new StringBuilder(ans);

                    
                        result.append((char) ('a' + c));
                        freq[c]--;

                        for (int k = 0; k < 26; k++) {
                            while (freq[k] > 0) {
                                result.append((char) ('a' + k));
                                freq[k]--;
                            }
                        }

                        return result.toString();
                    }
                }
            }
        }

        return "";
    }
}