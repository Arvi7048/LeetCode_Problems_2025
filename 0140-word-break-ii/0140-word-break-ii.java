class Solution {
    Map<String, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, new HashSet<>(wordDict));
    }

    private List<String> dfs(String s, Set<String> wordDict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();

        if (s.isEmpty()) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> suffixBreaks = dfs(s.substring(word.length()), wordDict);
                for (String suffix : suffixBreaks) {
                    res.add(word + (suffix.isEmpty() ? "" : " ") + suffix);
                }
            }
        }

        memo.put(s, res);
        return res;
    }
}
