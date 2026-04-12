import java.util.HashMap;

public class LeetCode_3_LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1) return s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0, j=0, maxlen = 0;
        while(j<s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>=i){
                int len = j-i;
                maxlen = Math.max(len,maxlen);
                while(s.charAt(i)!=ch) i++;
                i++;
            }
            map.put(s.charAt(j),j);
            j++;
        }
        int len = j-i;
        maxlen = Math.max(len,maxlen);
        return Math.min(maxlen,map.size());
    }
}
