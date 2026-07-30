
class Solution {

    private int ans = 0;

    class Info {
        int sum;
        int min;
        int max;
        boolean isBST;

        Info(int sum, int min, int max, boolean isBST) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }

    private Info helper(TreeNode root) {

        if (root == null) {
            return new Info(
                0,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE,
                true
            );
        }

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST && right.isBST &&
            left.max < root.val &&
            root.val < right.min) {

            int currSum = left.sum + right.sum + root.val;

            ans = Math.max(ans, currSum);

            return new Info(
                currSum,
                Math.min(root.val, left.min),
                Math.max(root.val, right.max),
                true
            );
        }

        return new Info(
            0,
            Integer.MIN_VALUE,
            Integer.MAX_VALUE,
            false
        );
    }
}