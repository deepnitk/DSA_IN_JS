//Brute force
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        ArrayList<Node> path = new ArrayList<>();
        path = findPath(p);
        while (q.parent != null) {
            for (Node node: path) {
                if (node == q) return q;
            }
            q = q.parent;
        }
        return q;
    }

    public ArrayList<Node> findPath(Node p) {
        ArrayList<Node> path = new ArrayList<>();
        while(p.parent != null) {
            path.add(p);
            p = p.parent;
        }
        return path;
    }
}
