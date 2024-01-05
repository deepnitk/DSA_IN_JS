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
 * @return {boolean}
 */
var isBalanced = function(root) {
    if (!root) {
        return true;
    }
    let leftHeight = checkHeight(root.left);
    let rightHeight = checkHeight(root.right);
     if (Math.abs(leftHeight - rightHeight) > 1) {
         return false;
     }
     let left = isBalanced(root.left);
     let right = isBalanced(root.right);
     if (!left || !right) {
         return false;
     }
     return true;
};

function checkHeight(node) {
    if(node == null) {
        return 0;
    }
    let leftHeight = checkHeight(node.left);
    let rightHeight = checkHeight(node.right);
    return 1 + Math.max(leftHeight, rightHeight);
}
