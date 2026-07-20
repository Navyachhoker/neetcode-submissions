class Solution {
    public int maxProfit(int[] prices) {
        int maxp = 0;
        for(int i = 0; i< prices.length -1; i++){
            for(int j = i; j< prices.length ; j++){
                maxp = Math.max(prices[j]-prices[i] , maxp);
            }
        }

        return maxp;
    }
}
