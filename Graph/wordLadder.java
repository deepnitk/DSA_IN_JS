class Pair {
    String word;
    int level;
    Pair(String _word, int _level) {
        this.word = _word;
        this.level = _level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> wordSet = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            wordSet.add(wordList.get(i));
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            String word = q.peek().word;
            int level = q.peek().level;
            q.remove();

            if (word.equals(endWord)) return level;

            int len = word.length();
            for (int i = 0; i  < len; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    
                    if (wordSet.contains(replacedWord)) {
                        q.offer(new Pair(replacedWord, level + 1));
                        wordSet.remove(replacedWord);
                    }
                }
            }

        }
        return 0;
    }
}
