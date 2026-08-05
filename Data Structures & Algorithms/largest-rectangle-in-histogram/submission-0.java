class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int height = heights[i];

            int left = i;
            while (left >= 0 && heights[left] >= height) {
                left--;
            }

            int right = i;
            while (right < n && heights[right] >= height) {
                right++;
            }

            int width = right - left - 1;
            int area = height * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}