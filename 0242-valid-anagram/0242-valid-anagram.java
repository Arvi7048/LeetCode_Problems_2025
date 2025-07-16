class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26]; // 26 letters of the alphabet

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++; // Increase count for s
            freq[t.charAt(i) - 'a']--; // Decrease count for t
        }

        // If all values are 0, it's an anagram
        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
