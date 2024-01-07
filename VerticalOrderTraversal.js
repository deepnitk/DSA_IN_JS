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
var verticalTraversal = function(root) {
    const nodeInfos = []; //holds the x, y, val info of node
    getNodesInfo(root, 0, 0);

    nodeInfos.sort((a, b) => a[0] - b[0] || b[1] - a[1] || a[2] - b[2]);
    
    const map = new Map();
    
    for (const [x, y, val] of nodeInfos) {
        if (!map.has(x)) map.set(x, []);
        map.get(x).push(val);
    }
    
    return [...map.values()];
    function getNodesInfo(node, x, y) {
        if (node) {
            getNodesInfo(node.left, x - 1, y - 1);
            nodeInfos.push([x, y, node.val]);
            getNodesInfo(node.right, x + 1, y - 1);
        }
    }
};
