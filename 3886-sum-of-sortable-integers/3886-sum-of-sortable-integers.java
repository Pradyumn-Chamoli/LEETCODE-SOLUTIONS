
class Solution {

   
    private void computeLPS(int[] pattern, int[] lps) {
        int m = pattern.length;
        int len = 0;
        int i = 1;

        lps[0] = 0;

        while (i < m) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

 
    private boolean KMPSearch(int[] pattern, int[] text) {
        int m = pattern.length;
        int n = text.length;

        int[] lps = new int[m];
        computeLPS(pattern, lps);

        int i = 0; 
        int j = 0;

        while (i < n) {
            if (pattern[j] == text[i]) {
                i++;
                j++;
            }

            if (j == m) {
                return true;
            } else if (i < n && pattern[j] != text[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    private boolean isRotationPossible(
            int[] original, int[] sorted, int start, int k) {

        int[] pattern = new int[k];
        int[] text = new int[2 * k];

        for (int i = 0; i < k; i++) {
            pattern[i] = sorted[start + i];

            text[i] = original[start + i];
            text[i + k] = original[start + i];
        }

        return KMPSearch(pattern, text);
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int result = 0;

       
        for (int k = 1; k <= n; k++) {

          
            if (n % k != 0) {
                continue;
            }

            boolean valid = true;

      
            for (int start = 0; start < n; start += k) {

                if (!isRotationPossible(nums, sorted, start, k)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result += k;
            }
        }

        return result;
    }
}