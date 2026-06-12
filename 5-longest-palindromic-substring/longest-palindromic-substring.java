class Solution {
    public String longestPalindrome(String s) {

        int begin = 0;
        int longest = 1;

        int len = s.length();

        for (int i = 0; i < len; i++) {

            // odd length palindrome
            int l = i;
            int r = i;

            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > longest) {
                    begin = l;
                    longest = r - l + 1;
                }

                l--;
                r++;
            }

            // even length palindrome
            l = i;
            r = i + 1;

            while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {

                if (r - l + 1 > longest) {
                    begin = l;
                    longest = r - l + 1;
                }

                l--;
                r++;
            }
        }

        return s.substring(begin, begin + longest);
    }
}