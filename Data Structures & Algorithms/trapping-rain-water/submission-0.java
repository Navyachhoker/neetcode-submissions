class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int[] maxl = new int[n];
        int[] maxr = new int[n];

        maxl[0] = height[0];
        for(int i = 1; i < n; i++){
            maxl[i] = Math.max(maxl[i - 1], height[i]);
        }

        maxr[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0; i--){
            maxr[i] = Math.max(maxr[i + 1], height[i]);
        }

        int water = 0;

        for(int i = 0; i < n; i++){
            water += Math.min(maxl[i], maxr[i]) - height[i];
        }

        return water;
    }
}