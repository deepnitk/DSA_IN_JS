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
        List<Integer> preorder = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            // Case 1: if left is done, print and move right.
            if (curr.left == null) {
                preorder.add(curr.val); //no left, hence add it to inorder
                curr = curr.right;
            } else { // Case 2: if left exist, go left and find its right most node.
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                // case 2.1: no thread yet.
                if (prev.right == null) {
                    prev.right = curr; //create thread
                    preorder.add(curr.val); //add root
                    curr = curr.left; // move left
                } else { //case 2.2: thread exist. break the thread and move right.
                    prev.right = null;
                    
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}
