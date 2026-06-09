import java.util.*;
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (right - left + 1 > p.length()) {
                char rem = s.charAt(left);
                window.put(rem, window.get(rem) - 1);
                if (window.get(rem) == 0) window.remove(rem);
                left++;
            }
            if (window.equals(pMap)) result.add(left);
        }
        return result;
    }
}