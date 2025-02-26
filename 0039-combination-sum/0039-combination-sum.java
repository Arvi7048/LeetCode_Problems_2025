class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
    
List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentCombination, 
                           int[] candidates, int target, int startIndex) {
        // Base case: if the current combination sums to the target
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        // If the target is less than 0, no valid combination can be formed
        if (target < 0) {
            return;
        }
        
        // Explore further with each candidate starting from startIndex
        for (int i = startIndex; i < candidates.length; i++) {
            // Include candidates[i] in the combination
            currentCombination.add(candidates[i]);
            // Give the current number another chance, rather than moving on
            backtrack(result, currentCombination, candidates, target - candidates[i], i);
            // Backtrack, remove the last added candidate
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(solution.combinationSum(candidates1, target1)); 
        // Output: [[2, 2, 3], [7]]

        // Example 2
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(solution.combinationSum(candidates2, target2)); 
        // Output: [[2, 2, 2, 2], [2, 3, 3], [3, 5]]

        // Example 3
        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(solution.combinationSum(candidates3, target3)); 
        // Output: []
    }
}