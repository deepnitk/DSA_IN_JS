PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.dist - y.dist);
        
        int[] dist = new int[V];
        for( int i = 0; i < V; i++) {
            dist[i] = (int)(1e9);
        }
        
        dist[S] = 0;
        pq.add(new Pair(0, S));
        
        while(!pq.isEmpty()) {
            int currWeight = pq.peek().dist;
            int node = pq.peek().node;
            
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                
                if (dist[adjNode] > currWeight + edgeWeight) {
                    dist[adjNode] = currWeight + edgeWeight;
                    pq.add(new Pair(currWeight + edgeWeight , adjNode));
                }
                
            }
        }
        return dist;
