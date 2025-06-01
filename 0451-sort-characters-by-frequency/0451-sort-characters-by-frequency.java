import java.util.*;

public class Solution {
    public String frequencySort(String s) {
        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        // Step 2: Bucket sort (array of StringBuilder)
        int maxFreq = s.length();
        List<Character>[] buckets = new List[maxFreq + 1];

        for (char c : freqMap.keySet()) {
            int freq = freqMap.get(c);
            if (buckets[freq] == null)
                buckets[freq] = new ArrayList<>();
            buckets[freq].add(c);
        }

        // Step 3: Build result from high to low frequency
        StringBuilder sb = new StringBuilder();
        for (int i = maxFreq; i >= 1; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
