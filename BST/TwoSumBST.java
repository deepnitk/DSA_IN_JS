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

 class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    boolean reverse = true;
    public BSTIterator(TreeNode root, boolean isReverse) {
        reverse = isReverse;
        pushAll(root);
    }
    
    public int next() {
        TreeNode top = st.pop();
        if (reverse == false) pushAll(top.right);
        else pushAll(top.left);
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            if (reverse == true) {
                node = node.right;
            } else {
                node = node.left;
            } 
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k) return true;
            else if (i + j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }
}
