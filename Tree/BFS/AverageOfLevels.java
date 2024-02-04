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
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                root = q.poll();
                level.add(root.val);
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            result.add(level);
        }

        for (List<Integer> level : result) {
            double size = level.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum += level.get(i);
            }
            double average = sum / size;
            ans.add(average);
        }

        return ans;
    }
}
