class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //create count1[26] and windowCount[26]
        //fill them 
        //compare them
        //if true return true, if false then 
        //move the window to right

        if(s1.length()>s2.length()){
            return false;
        }

        int[] s1count = new int[26];
        int[] windowCount = new int[26];

        //fill
        for(int i = 0 ; i<s1.length(); i++){
            s1count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        //compare
        if(Arrays.equals(s1count, windowCount)){
            return true;
        }

        //else move the window to right
        for(int right = s1.length(); right<s2.length(); right++){
            windowCount[s2.charAt(right) - 'a' ]++;
            //delete
            windowCount[s2.charAt(right - s1.length()) - 'a']--;

        if(Arrays.equals(s1count, windowCount)){
            return true;
        }
        }
        return false;
    }
}
