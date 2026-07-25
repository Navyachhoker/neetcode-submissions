class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0 ;
        int right = k-1;
        

        List<Integer> result = new ArrayList<>();

        while(right <= nums.length -1){
            int maxValue = Integer.MIN_VALUE;
            for(int i = left; i<=right; i++){
                maxValue = Math.max(maxValue, nums[i]);
            }

            result.add(maxValue);
            left++;
            right++;
        }
        //convert aaraylist to array
        int[] ans = new int[result.size()];
        for(int i = 0 ; i<result.size(); i++){
            ans[i]= result.get(i);
        }
    


        return ans;

    }
}
