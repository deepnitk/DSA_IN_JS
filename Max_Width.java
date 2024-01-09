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

class Pair {
    TreeNode node;
    int num;
    public Pair(TreeNode _node, int _num) {
        this.node = _node;
        this.num = _num;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            // to make id start with 0
            int min_i = q.peek().num;
            int first = 0, last = 0;
            for (int i = 0; i < size; i++) { 
                int curr_id = q.peek().num - min_i;
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0) first = curr_id;
                if (i == size - 1) last = curr_id;
                if (node.left != null) {
                    q.offer(new Pair(node.left, 2*curr_id + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, 2*curr_id + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
