import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words)
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);

        // Step 2: Min-Heap with custom comparator
        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int freqCompare = freqMap.get(w1) - freqMap.get(w2);
            if (freqCompare == 0)
                return w2.compareTo(w1); // reverse alphabetical
            return freqCompare;
        });

        // Step 3: Keep top k elements
        for (String word : freqMap.keySet()) {
            heap.offer(word);
            if (heap.size() > k)
                heap.poll();
        }

        // Step 4: Extract from heap into a list (reverse order)
        LinkedList<String> result = new LinkedList<>();
        while (!heap.isEmpty())
            result.addFirst(heap.poll());

        return result;
    }
}
