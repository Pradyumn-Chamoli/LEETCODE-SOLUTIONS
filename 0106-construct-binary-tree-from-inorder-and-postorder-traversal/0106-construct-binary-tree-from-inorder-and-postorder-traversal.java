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

    private TreeNode buildTrees(int[] postorder , int ps , int pe , int[] inorder , int is , int ie , HashMap<Integer , Integer> map){
        if(ps>pe || is>ie){
            return null;
        }

        TreeNode root = new TreeNode(postorder[pe]);

        int inRoot = map.get(root.val);
        int numsLeft = inRoot - is;

        root.left = buildTrees(postorder , ps , ps+numsLeft-1 , inorder , is , inRoot-1 , map);
        root.right = buildTrees(postorder , ps+numsLeft , pe-1 , inorder ,inRoot+1 , ie  , map);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length){
            return null;
        }
        HashMap<Integer , Integer> map  = new HashMap<>();

        for(int i=0 ; i<inorder.length ; i++){
            map.put(inorder[i] , i);
        }

        TreeNode root = buildTrees(postorder , 0 , postorder.length-1 , inorder , 0 , inorder.length , map);

        return root;

    }
}