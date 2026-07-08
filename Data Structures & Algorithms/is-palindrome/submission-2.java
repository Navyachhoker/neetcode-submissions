class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder cleaned = new StringBuilder();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                cleaned.append(Character.toLowerCase(c));
            }
        }

        char[] original = cleaned.toString().toCharArray();
        char[] reversed = new char[original.length];

        for(int i = 0; i<original.length; i++){
            reversed[i] = original[original.length-1-i];
        }

        //compare
        for(int i = 0; i< original.length; i++){
            if(original[i] != reversed[i]){
                return false;
            }
        }

        return true;
    }
}
