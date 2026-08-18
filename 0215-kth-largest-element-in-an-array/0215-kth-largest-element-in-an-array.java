class Solution {

    private Random rand = new Random();

    private int randomIndex(int left, int right) {
        int len = right - left + 1;
        return rand.nextInt(len) + left;
    }

    private int partitionAndReturnIndex(int[] nums, int pivotIndex, int left, int right) {

        int temp = nums[left];
        nums[left] = nums[pivotIndex];
        nums[pivotIndex] = temp;

        int pivot = nums[left];

        int ind = left + 1;

        for (int i = left + 1; i <= right; i++) {

            if (nums[i] > pivot) {

                temp = nums[ind];
                nums[ind] = nums[i];
                nums[i] = temp;

                ind++;
            }
        }

        temp = nums[left];
        nums[left] = nums[ind - 1];
        nums[ind - 1] = temp;

        return ind - 1;
    }

    public int findKthLargest(int[] nums, int k) {

        if (k > nums.length) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (true) {

            int pivotIndex = randomIndex(left, right);

            pivotIndex = partitionAndReturnIndex(
                nums, pivotIndex, left, right
            );

            if (pivotIndex == k - 1) {
                return nums[pivotIndex];
            }

            else if (pivotIndex > k - 1) {
                right = pivotIndex - 1;
            }

            else {
                left = pivotIndex + 1;
            }
        }
    }
}