class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int low = 0; int high = 0 ; 
     for(int w : weights){
        low = Math.max(low, w);
        high+= w;
     }   
     int ans = high;
     while(low<= high){
        int mid= low+(high-low)/2;
        int neededDays = 1;
        int currentload = 0;

        for(int w:weights){
            if(currentload+ w > mid){
                neededDays++;
                currentload = w;
            }
            else{
                currentload += w;
            }
        }

        if(neededDays <= days){
            ans = mid;
            high = mid-1;
        }
        else{
            low = mid+1;
        }
     }
     return ans;
    }
}