/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} targetSum
 * @return {boolean}
 */
var hasPathSum = function(root, targetSum) {
    if (!root) {
        return false;
    }
    
    function dfs(root, targetSum) {
        if (!root) {
            return false;
        }
        if (!root.left && !root.right) {
            return targetSum - root.val === 0;
        }
        return dfs(root.left, targetSum - root.val) || 
            dfs(root.right, targetSum - root.val);
    }
    return dfs(root, targetSum);
};
