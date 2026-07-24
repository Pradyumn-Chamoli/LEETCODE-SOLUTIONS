/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode , TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left!=null){
                parentMap.put(node.left , node);
                q.offer(node.left);
            }

            if(node.right!=null){
                parentMap.put(node.right , node);
                q.offer(node.right);
            }
        }

        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int currDis = 0;

        while(!q.isEmpty()){
            if(currDis==k){
                while(!q.isEmpty()){
                    result.add(q.poll().val);
                }
                return result;
            }
            int size = q.size();
            for(int i=0 ; i<size ; i++){
                TreeNode node = q.poll();
                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    q.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
            currDis++;
        }

        return result;

    }
}