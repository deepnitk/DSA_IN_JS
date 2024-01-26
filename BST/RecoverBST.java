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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode last;
    private TreeNode prev;
    private void inorder(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inorder(curr.left);

        if (prev != null && prev.val > curr.val) {
            //if it is first violation mark these nodes as first and middle
            if (first == null) {
                first = prev;
                middle = curr;
            } else { //if its 2nd violation, mark this root as last
                last = curr;
            }
        }
        //mark curr node as prev
        prev = curr;
        inorder(curr.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int t = first.val;
            first.val = last.val;
            last.val = t;
        } else if (first != null && middle != null) {
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}
