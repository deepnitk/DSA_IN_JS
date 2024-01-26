class Solution {
    public String alienOrder(String[] words) {
        int N = words.length;

        Map<Character, Set<Character>> adjMap=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> inDegree=new HashMap<Character, Integer>();
        if(words==null || words.length==0) return "";
        for(String s: words){
            for(char c: s.toCharArray()){
                inDegree.put(c,0);
            }
        }

        for(int i = 0; i < N - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                char c1 = s1.charAt(ptr);
                char c2 = s2.charAt(ptr);
                if (c1 != c2) {
                    Set<Character> set=new HashSet<Character>();
                    if(adjMap.containsKey(c1)) set = adjMap.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        adjMap.put(c1, set);
                        inDegree.put(c2, inDegree.get(c2)+1);
                    }
                    break;
                }
            }
        }

        List<Character> topo = toposort(inDegree, adjMap);
        String ans = "";
        for (char it: topo) {
            ans = ans + it;
        }
        if(ans.length() != inDegree.size()) return "";
            return ans;
    }

    private List<Character> toposort(Map<Character, Integer> inDegree, Map<Character, Set<Character>> adjMap) {

        Queue<Character> q = new LinkedList<>();
        for(char c: inDegree.keySet()) {
            if(inDegree.get(c)==0) q.add(c);
        }

        List<Character> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            char node = q.peek();
            q.remove();
            topo.add(node);
            if(adjMap.containsKey(node)){
                for(char it: adjMap.get(node)){
                    inDegree.put(it ,inDegree.get(it)-1);
                    if(inDegree.get(it)==0) q.add(it);
                }
            }
        }
        return topo;
    }
}
