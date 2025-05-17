class Solution {
    public List<List<Integer>> fourSum(int[] nums, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        int n= nums.length;
        Arrays.sort(nums);
        for(int i = 0; i<n; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j<n;){
                int p = j+1, q = n-1;
                while(p < q){
                    long sum = (long)nums[i]+ nums[j]+ nums[p]+ nums[q];

                    if(sum< t){
                        p++;
                    }else if(sum> t){
                        q--;
                    }else{
                        ans.add(Arrays.asList( nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;

                        while( p<q && nums[p]  == nums[p-1]) p++;
                    }

                } 
                j++;
                while(j <n && nums[j] == nums[j-1])  j++;

            }
        }
        return ans;
    }
}