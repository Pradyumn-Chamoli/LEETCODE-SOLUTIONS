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
 class BSTIterator{
    private Stack<TreeNode> stack;
    private boolean reverse;

    public BSTIterator(TreeNode root , boolean isReverse){
        stack = new Stack<>();
        reverse = isReverse;
        pushAll(root);
    }

    public void pushAll(TreeNode node){
        while(node!=null){
            stack.push(node);
            node = (reverse) ? node.right : node.left;
        }
    }

    public int next(){
        TreeNode node = stack.pop();
        if(!reverse){
            pushAll(node.right);
        }
        else{
            pushAll(node.left);
        }
        return node.val;
    }



 }

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;

        BSTIterator l = new BSTIterator(root , false);
        BSTIterator r = new BSTIterator(root , true);

        int i = l.next();
        int j = r.next();

        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k){
                i = l.next();
            }
            else{
                j=r.next();
            }
        }

        return false;


    }
}