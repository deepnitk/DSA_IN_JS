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
 * @return {number}
 */
var pathSum = function(root, targetSum) {
    if (!root) {
        return 0;
    }
    let count = 0;

    function helper(node, sum) {
        if(!node) return;
        sum += node.val;
        if (sum === targetSum) count++;
        return helper(node.left, sum) || helper(node.right, sum)
    }

    function dfs(node) {
        if (!node) return;

        //inorder
        node.left && dfs(node.left);
        helper(node, 0); //instantiate a new sum of 0 at each node
        node.right && dfs(node.right);
    }
    dfs(root);
    return count;
};

