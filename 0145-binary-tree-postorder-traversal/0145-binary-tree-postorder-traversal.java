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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st  = new Stack<>();

        List<Integer> postorder = new ArrayList<>();

        if(root!=null) {
            st.push(root);
        }

        while(!st.empty()){

            TreeNode node = st.pop();
            postorder.add(node.val);

            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);

        }


        Collections.reverse(postorder);

        return postorder;
    }
}