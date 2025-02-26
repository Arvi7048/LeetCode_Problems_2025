import java.util.*;
class Solution {
    void printSubset(int[] arr, Vector<Integer> ans, int i,List<List<Integer>> allSubset){
        if(i == arr.length){
            allSubset.add(new Vector<>(ans));
                return;
            }

        ans.add(arr[i]);
        printSubset(arr,ans,i+1, allSubset);
        ans.remove(ans.size()-1);
        printSubset(arr,ans,i+1, allSubset);
        }
    
    public List<List<Integer>> subsets(int[] arr) {
        int n = arr.length;
         List<List<Integer>> allSubset = new Vector<>();

                Vector<Integer> ans = new Vector<>();
                
                printSubset(arr,ans,0,allSubset);
                return allSubset;

        
    }
}