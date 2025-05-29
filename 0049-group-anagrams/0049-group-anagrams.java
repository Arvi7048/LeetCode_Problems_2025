import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Sort the characters of the string
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // Sorted string as key

            // Group anagrams using the sorted key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
