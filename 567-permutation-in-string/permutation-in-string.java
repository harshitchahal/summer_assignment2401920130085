import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character, Integer> target = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> current = new HashMap<>();

        int left = 0;
        int size = s1.length();

        for (int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);
            current.put(ch, current.getOrDefault(ch, 0) + 1);

            if (right - left + 1 > size) {
                char remove = s2.charAt(left);

                current.put(remove, current.get(remove) - 1);

                if (current.get(remove) == 0) {
                    current.remove(remove);
                }

                left++;
            }

            if (right - left + 1 == size && target.equals(current)) {
                return true;
            }
        }

        return false;
    }
}