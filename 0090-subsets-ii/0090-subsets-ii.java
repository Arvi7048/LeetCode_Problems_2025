class Solution {
    private static void findsubset(int[] arr,List<List<Integer>> ans,int ind,List<Integer>subset){
        ans.add(new ArrayList<>(subset));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind && arr[i]==arr[i-1]) continue;
            subset.add(arr[i]);
            findsubset(arr,ans,i+1,subset);
            subset.remove(subset.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans =new ArrayList<>();
        findsubset(nums,ans,0,new ArrayList<>());
        return ans;
    }
}