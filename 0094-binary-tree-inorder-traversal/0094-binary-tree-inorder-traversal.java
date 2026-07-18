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

    private  void recursiveInorder(TreeNode root , List<Integer> arr){
        if(root==null){
            return;
        }

        recursiveInorder(root.left , arr);
        arr.add(root.val);
        recursiveInorder(root.right , arr);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();

        recursiveInorder(root , arr);

        return arr;
    }
}