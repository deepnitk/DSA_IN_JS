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
 * @return {number[][]}
 */
var zigzagLevelOrder = function(root) {
    if (!root) {
        return [];
    }
    let result = [];
    let queue = [root];
    let leftToRight  = true;
    while (queue.length > 0) {
        var currentLength = queue.length;
        let currentLevel = [];
        for (let i = 0; i < currentLength; i++) {
            let currNode = queue.shift();
            if (currNode.left) {
                queue.push(currNode.left);
            }
            if (currNode.right) {
                queue.push(currNode.right);
            }
            let index = (leftToRight) ? i : currentLength - 1 - i;
            currentLevel[index] = currNode.val;
        }
        leftToRight = !leftToRight;
        result.push(currentLevel);
        
    }
    return result;
};
