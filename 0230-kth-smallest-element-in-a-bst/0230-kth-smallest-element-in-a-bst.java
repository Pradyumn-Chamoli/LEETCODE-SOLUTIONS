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
    private void inorder(TreeNode root, List<Integer> List) {
        if (root == null) {
            return;
        }

        inorder(root.left, List);
        List.add(root.val);
        inorder(root.right, List);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> InorderList = new ArrayList<>();
        inorder(root, InorderList);

        return InorderList.get(k-1);


    }
}