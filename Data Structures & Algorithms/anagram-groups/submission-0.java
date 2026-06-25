class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>>map = new HashMap<>();
        //key: word, value: frequency of the the words

        for(String s: strs){

            int[] count = new int[26];//for storing an the frrquency of char

            for( char ch: s.toCharArray()){
                count[ch - 'a']++; //ch is converted to ascii and then count is increamented
            }

            StringBuilder key = new StringBuilder();//sb is a class used for string manipulation

            //key is an obj of that class


            for(int num : count){
                key.append(num).append("#");
            }

            String k = key.toString();

            map.putIfAbsent(k, new ArrayList<>());//if freq pattern is seen for the 1st time, create a new list list
            map.get(k).add(s);


        }
    return new ArrayList<>(map.values());



    }
}
