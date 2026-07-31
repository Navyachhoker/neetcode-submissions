class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        //2d array for storing position and time taken
        //sort it by position (lager num means closer to the target)
        //compare the time taken if current is greater than maxtime which was the max time of prev cars , then it is another fleet fleet++
        int n = position.length;

        double[][] arr = new double[n][2];

        for(int i = 0 ; i<n; i++){
            arr[i][0]= position[i];
            arr[i][1] = (double)(target - position[i]) / speed[i];

        }

        Arrays.sort(arr,(a,b)->Double.compare(a[0],b[0]));

        int fleet = 0;
        double maxtime=0;

        for(int i = n-1; i>=0;i--){
            double currentime = arr[i][1];

            if(currentime > maxtime){
                fleet++;
                maxtime = currentime;
            }
        }
        return fleet;
    }
}
