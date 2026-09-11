class Solution {
    public int totalNumbers(int[] digits) {

        int[] count = new int[10];


        for (int digit : digits) {
            count[digit]++;
        }

        int ans = 0;

        for (int units = 0; units <= 8; units += 2) {

            if (count[units] == 0)
                continue;

            count[units]--;

         
            for (int hundreds = 1; hundreds <= 9; hundreds++) {

                if (count[hundreds] == 0)
                    continue;

                count[hundreds]--;

               
                for (int tens = 0; tens <= 9; tens++) {

                    if (count[tens] > 0) {
                        ans++;
                    }
                }

                count[hundreds]++;
            }

            count[units]++;
        }

        return ans;
    }
}