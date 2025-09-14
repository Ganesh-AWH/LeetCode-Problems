// Last updated: 9/14/2025, 9:16:48 AM
class Pair{
    String word;
    int level;
    Pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //thus we want to cound the level use bfs algorithm
        Set<String> set = new HashSet<>();
        for(String s:wordList) set.add(s);

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        set.remove(beginWord);

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            int level = p.level;
            if(endWord.equals(word)) return level;
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char []arr = word.toCharArray();
                    arr[i] = c;
                    String str = new String(arr);
                    if(set.contains(str)){
                        set.remove(str);
                        queue.add(new Pair(str,level+1));
                    }
                }
            }
        }

        return 0;
    }
}