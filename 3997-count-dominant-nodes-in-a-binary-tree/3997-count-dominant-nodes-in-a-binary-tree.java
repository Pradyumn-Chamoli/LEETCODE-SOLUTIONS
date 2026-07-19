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

    int ans = 0;

    private int dfs(TreeNode node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        

        int leftM = dfs(node.left);
        int rightM = dfs(node.right);

        int max = Math.max(node.val , Math.max(leftM , rightM));
        if(node.val==max){
            ans++;
        }

        return max;
    }
    public int countDominantNodes(TreeNode root) {
        dfs(root);
        return ans;  
    }

    
}