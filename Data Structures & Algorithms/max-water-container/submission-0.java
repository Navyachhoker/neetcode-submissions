class Solution {
    public int maxArea(int[] heights) {
        
        int m_area = 0;

        int left= 0;
        int right = heights.length -1;

        while(left<right){
            int area = (right- left)*
                        Math.min(heights[left],heights[right] );

            m_area = Math.max(area, m_area);

            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }

        return m_area;

    }
}
