/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int max = Integer.MIN_VALUE;

    private int findPathSum(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMaxPath = Math.max(0 , findPathSum(root.left));
        int rightMaxPath = Math.max(0 , findPathSum(root.right));

        max = Math.max(max , leftMaxPath + rightMaxPath + root.val);

        return Math.max(leftMaxPath , rightMaxPath) + root.val;
    }
    public int maxPathSum(TreeNode root) {

        findPathSum(root);

        return max;


    }
}