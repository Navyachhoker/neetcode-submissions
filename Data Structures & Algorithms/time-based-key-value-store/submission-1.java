class Pair {
    int timestamp;
    String value;

    Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
class TimeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> arr = map.get(key);

        int l = 0;
        int r= arr.size() -1;

        String ans = "";

        while(l<=r){
            int mid=  l + (r-l)/2;

            if(arr.get(mid).timestamp <= timestamp ){
                ans = arr.get(mid).value;
                l= mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return ans;
    }
}
