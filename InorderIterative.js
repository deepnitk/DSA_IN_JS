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
 * @return {number[]}
 */
var inorderTraversal = function(root) {
    if (!root) {
        return [];
    }
    var result = [];
    var stack = [];
    var node = root;
    while (true) {
        if (node) {
            stack.push(node);
            node = node.left;
        } else {
            if (stack.length == 0) {
                break;
            }
            node = stack.pop();
            result.push(node.val);
            node = node.right;
        }
    }
    return result;
};
