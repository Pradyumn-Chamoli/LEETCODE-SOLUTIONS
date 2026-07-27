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
    private TreeNode connector(TreeNode root){
        if(root.left==null) return root.right;

        if(root.right==null) return root.left;

        TreeNode leftChild = root.left;
        TreeNode leftmostChild = root.right;

        while(leftmostChild.left!=null){
            leftmostChild = leftmostChild.left;
        }

        leftmostChild.left = leftChild;

        return root.right;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val==key){
            return connector(root);
        }

        TreeNode node = root;
        while(node!=null){
            if(node.val>key){
                if(node.left!=null && node.left.val==key){
                    node.left = connector(node.left);
                    break;
                }
                else{
                    node = node.left;
                }
            }
            else{
                if(node.right!=null && node.right.val==key){
                    node.right = connector(node.right);
                    break;
                }
                else{
                    node = node.right;
                }
            }
        }

        return root;

    }
}