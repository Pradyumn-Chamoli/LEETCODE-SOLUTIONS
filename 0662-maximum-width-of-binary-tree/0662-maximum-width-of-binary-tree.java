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
class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node , int index){
            this.node = node;
            this.index = index;
        }
    }

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));

        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();

            int minIndex = q.peek().index;

            int first = 0;
            int last =0 ;

            for(int i=0 ; i<size ; i++){
                Pair curr = q.poll();

                int index = curr.index - minIndex;

                if(i==0){
                    first = index;
                }

                if(i==size-1){
                    last = index;
                }

                if(curr.node.left!=null){
                    q.offer(new Pair(curr.node.left , 2*index+1));
                }
                if(curr.node.right!=null){
                    q.offer(new Pair(curr.node.right , 2*index+2));
                }
            }

            maxWidth = Math.max(maxWidth , last-first+1);
        }

        return maxWidth;
    }
}