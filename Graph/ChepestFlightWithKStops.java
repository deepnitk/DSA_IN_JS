class Tuple {
    int stops;
    int node;
    int cost;
    Tuple(int _stops, int _node, int _cost) {
        this.stops = _stops;
        this.node = _node;
        this.cost = _cost;
    }
}
class Pair {
    int v;
    int price;
    Pair(int _v, int _price) {
        this.v = _v;
        this.price = _price;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] priceArray = new int[n]; 
        for(int i = 0;i<n;i++) {
            priceArray[i] = (int)(1e9); 
        }
        priceArray[src] = 0; 

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, src, 0));

       ArrayList<ArrayList<Pair>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        int m = flights.length; 
        for(int i = 0;i < m;i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2])); 
        }

        while (!q.isEmpty()) {
            int stops = q.peek().stops;
            int currNode = q.peek().node;
            int currCost = q.peek().cost;
            q.remove();
            if(stops > k) continue;
            for (Pair it: adj.get(currNode)) {
                int adjNode = it.v; 
                int edW = it.price; 
                
                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (currCost + edW < priceArray[adjNode] && stops <= k) {
                    priceArray[adjNode] = currCost + edW; 
                    q.add(new Tuple(stops + 1, adjNode, currCost + edW)); 
                }
            }
        }
        if(priceArray[dst] == (int)(1e9)) return -1; 
        return priceArray[dst];

    }
}
