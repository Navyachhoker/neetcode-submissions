class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        int n = (nums.length)/ 3;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key)> n){
                set.add(key);
            }
        }

        return new ArrayList<>(set);
       
    }
}