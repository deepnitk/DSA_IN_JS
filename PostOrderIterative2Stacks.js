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
var postorderTraversal = function(root) {
    if (!root) {
        return [];
    }

    let stack1 = [root];
    let stack2 = [];
    var result = [];

    while (stack1.length > 0) {
        let node = stack1.pop();
        // stack2.push(node);
        if (node.left != null) {
            stack1.push(node.left);
        }
        if (node.right != null) {
            stack1.push(node.right);
        }
        stack2.push(node.val);
    }

    while (stack2.length > 0) {
        result.push(stack2.pop());
    }

    return result;
    
};
