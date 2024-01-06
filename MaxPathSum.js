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
var maxPathSum = function(root) {
    let maxPath = - Number.MAX_VALUE;
    function dfs(root) {
        if (!root) {
            return 0;
        }
        const left = dfs(root.left);
        const right = dfs(root.right);
        maxPath = Math.max(maxPath, root.val + left + right);
        return Math.max(0, root.val + Math.max(left, right));
    }
    dfs(root);
    return maxPath;
};
