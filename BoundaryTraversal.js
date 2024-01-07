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
var boundaryOfBinaryTree = function(root) {
    if (!root) {
        return [];
    }
    let res = [];
    if (!isLeaf(root)) {
        res.push(root.val);
    }
    addLeftBoundary(root, res);
    addLeaves(root, res);
    addRightBoundary(root, res);
    return res;
};

function addLeftBoundary(node, res) {
    let curr = node.left;
    while (curr) {
        if (!isLeaf(curr)) {
            res.push(curr.val);
            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        } else {
            curr = null;
        }   
        
    }
}

function addLeaves(node, res) {
    if (isLeaf(node)) {
        res.push(node.val);
    }
    if (node.left) addLeaves(node.left, res);
    if(node.right) addLeaves(node.right, res);
}

function addRightBoundary(node, res) {
    let temp = [];
    let curr = node.right;
    while (curr != null) {
        if (isLeaf(curr) === false) {
            temp.push(curr.val);
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }  else {
            curr = null;
        }  
        
    }
    for (let i = temp.length - 1; i >= 0; i--) {
        res.push(temp[i])
    } 
}

function isLeaf(node) {
    if (!node.left && !node.right) return true;
    return false;
}
