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
class Pair {
    int node;
    int distance;
    Pair(int _node, int _distance) {
        this.node = _node;
        this.distance = _distance;
    }
}
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
	    PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
	    pq.offer(new Pair(0, 0));
	    
	    int[] vis = new int[V];
	    for(int i = 0; i < V; i++) {
	        vis[i] = 0;
	    }
	    
	    int sum = 0;
	    while (!pq.isEmpty()) {
	        int node = pq.peek().node;
	        int wt = pq.peek().distance;
	        pq.remove();
	        
	        if (vis[node] == 1) {
	            continue;
	        }
	        
	        vis[node] = 1;
	        sum += wt;
	        for (int i = 0; i < adj.get(node).size(); i++) {
	            int ewt = adj.get(node).get(i).get(1);
	            int adjNode = adj.get(node).get(i).get(0);
	            
	            if (vis[adjNode] == 0) {
	                pq.add(new Pair(adjNode, ewt));
	            }
	        }
	    }
	    return sum;
	 }
}
