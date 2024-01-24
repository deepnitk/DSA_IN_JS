//Best solution
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderUtil(preorder,  Integer.MAX_VALUE, new int[]{0});
    }

    TreeNode bstFromPreorderUtil(int[] preorder, int bound, int[] i) {
       if (i[0] == preorder.length || preorder[i[0]] > bound) {
           return null;
       }
       TreeNode root = new TreeNode(preorder[i[0]++]);
       root.left = bstFromPreorderUtil(preorder, root.val, i);
       root.right = bstFromPreorderUtil(preorder, bound, i);
       return root;
    }
}

//Naive solution

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        HashMap<Integer, Integer> iMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            iMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0 , preorder.length - 1, inorder, 0, inorder.length - 1, iMap);
        return root;
    }

    TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> iMap) {
       if (preStart > preEnd || inStart > inEnd) {
           return null;
       }

       TreeNode root = new TreeNode(preorder[preStart]);
       int inRoot = iMap.get(root.val);
       int numsLeft = inRoot - inStart;

       root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, iMap);
       root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, iMap);
       return root;
    }
} 
