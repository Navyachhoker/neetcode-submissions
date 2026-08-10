class Solution {
    public int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[r]) {
                // Minimum is to the right of mid
                l = mid + 1;
            } else {
                // mid could itself be the minimum
                r = mid;
            }
        }

        return nums[l];
    }
}