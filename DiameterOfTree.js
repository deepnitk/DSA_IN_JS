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
 * @return {number}
 */
var maxi = 0;
var diameterOfBinaryTree = function(root) {
    if (!root) {
        return 0;
    }
    let maxDiameter = 0;
    function dfs(node) {
        if (!node) {
            return 0;
        }
        let left = dfs(node.left);
        let right = dfs(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return 1 + Math.max(left, right);
    }
    dfs(root);
    return maxDiameter;
};
