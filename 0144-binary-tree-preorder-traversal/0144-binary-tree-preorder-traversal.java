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

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root ;

        List<Integer> preorder = new ArrayList<>();

        while(true){
            if(node!=null){
                preorder.add(node.val);
                st.push(node);
                node = node.left;
            }
            else{
                if(st.empty())break;

                node = st.pop();
                node = node.right;
            }
        }

        return preorder;
    }
}