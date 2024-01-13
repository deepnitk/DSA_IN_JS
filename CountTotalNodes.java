//Brute/Naive solution

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
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + dfs(root.left) + dfs(root.right);
    }
}

//O(log(N)^2) solution
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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if (lh == rh) {
            return (1 << lh) - 1;
        }

        int leftNodes = countNodes(root.left);
        int rightNodes = countNodes(root.right);

        return 1 + leftNodes + rightNodes;
    }

    private int findLeftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findLeftHeight(root.left);
        
    }

    private int findRightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + findRightHeight(root.right);
    }
}
