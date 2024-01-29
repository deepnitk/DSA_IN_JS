//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src;
        this.dest = _dest;
        this.weight = _wt;
    }
    
     public int compareTo(Edge compareEdge)
    {
 
        return this.weight - compareEdge.weight;
    }
};

class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n) {
        for(int i = 0; i < n; i++) {
            size.add(0);
            parent.add(i);
        }
    }
    
    public int findUpar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        
        if (ulp_u == ulp_v) {
            return;
        }
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
};

class Pair {
    int node;
    int distance;
    Pair(int _node, int _distance) {
        this.node = _node;
        this.distance = _distance;
    }
};

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
	    for(int i = 0; i < E; i++) {
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        
	        ArrayList<Integer> temp1 = new ArrayList<>();
	        ArrayList<Integer> temp2 = new ArrayList<>();
	        
	        temp1.add(v);
	        temp1.add(wt);
	        
	        temp2.add(u);
	        temp2.add(wt);
	        
	        adj.get(u).add(temp1);
	        adj.get(v).add(temp2);
	    }
	    
	    return spanningTreeUtil(V, adj);
	}
	
	static int spanningTreeUtil(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
	    List<Edge> edges = new ArrayList<>();
	    for (int i = 0; i < V; i++) {
	        for( int j = 0; j < adj.get(i).size(); j++) {
	            int adjNode =adj.get(i).get(j).get(0);
	            int wt = adj.get(i).get(j).get(1);
	            int node = i;
	            Edge temp = new Edge(i, adjNode, wt);
	            edges.add(temp);
	        }
	    }
	    
	    DisjointSet ds = new DisjointSet(V);
	    Collections.sort(edges);
	    
	    int mstWt = 0;
	    
	    for(int i = 0; i  < edges.size(); i++) {
	        int wt = edges.get(i).weight;
	        int u = edges.get(i).src;
	        int v = edges.get(i).dest;
	        
	        if (ds.findUpar(u) != ds.findUpar(v)) {
	            mstWt += wt;
	            ds.unionBySize(u, v);
	        }
	    }
	    return mstWt;
	}
}
