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
    private TreeNode buildTrees(int [] preorder , int preStart , int preEnd , int []inorder , int inStart ,int inEnd , HashMap<Integer , Integer> map){

        if(preStart > preEnd || inStart > inEnd)return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        root.left = buildTrees(preorder , preStart+1 , preStart+numsLeft , inorder , inStart , inRoot-1 , map);

        root.right = buildTrees(preorder , preStart + numsLeft + 1 , preEnd , inorder , inRoot+1 , inEnd , map);

        return root;


    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        TreeNode root = buildTrees(preorder , 0 , preorder.length-1 , inorder , 0 , inorder.length-1 , map);

        return root;
    }


}