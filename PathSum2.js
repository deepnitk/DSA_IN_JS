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
 * @return {number[][]}
 */
var pathSum = function(root, targetSum) {
    if (!root) {
        return [];
    }
    const result = [];
    dfs(root, targetSum, result , []);
    return result;
};

function dfs(root, targetSum, result, tempList) {
    if (!root) {
        return;
    }
    if (!root.left && !root.right && targetSum - root.val === 0) {
        return result.push([...tempList, root.val]);
    }
    tempList.push(root.val);
    dfs(root.left, targetSum - root.val, result, tempList)
    dfs(root.right, targetSum - root.val, result, tempList);
    tempList.pop();
}
