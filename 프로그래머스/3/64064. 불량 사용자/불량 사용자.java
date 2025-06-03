import java.util.*;

class Solution {
    static String[] uid,bid;
    static Set<Set<String>> answer = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        uid = user_id;
        bid = banned_id;
        dfs(new HashSet<>(),0);
        return answer.size();
    }
    
    private void dfs(Set<String> set, int depth) {
        if(depth == bid.length) {
            answer.add(new HashSet<>(set));
            return;
        } else {
            for(String s: uid) {
                if(set.contains(s)) continue;
                if(same(s,bid[depth])) {
                    set.add(s);
                    dfs(set, depth+1);
                    set.remove(s);
                }
            }
            
        }
    }
    
    private boolean same(String a, String b) {
        if(a.length() != b.length())
            return false;
        
        for(int i=0;i<a.length();i++){
            if(b.charAt(i) == '*') continue;
            if(a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }
}