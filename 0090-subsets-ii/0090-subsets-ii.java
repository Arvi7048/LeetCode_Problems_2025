import java.util.*;
class Solution {

    void getSubset(int[] arr, List<Integer> ans, List<List<Integer>> result,int i){
        if(i == arr.length){
            result.add(new Vector<>(ans));
                return;
            }

      
      //include
        ans.add(arr[i]);

        getSubset(arr,ans,result,i+1);

        ans.remove(ans.size()-1);// backtrack
        int ind = i+1;
        while(ind < arr.length && arr[ind] == arr[ind-1]){
            ind++;
        } 
        //exclude
        getSubset(arr,ans,result,ind);

    }   
         

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new Vector<>();
        List<Integer> ans = new Vector<>();
        getSubset(arr,ans,result,0);
        return result;
    }
}