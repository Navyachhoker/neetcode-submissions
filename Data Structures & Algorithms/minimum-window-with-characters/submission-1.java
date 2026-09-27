class Solution {
    public String minWindow(String s, String t) {

        // If t is longer than s, answer is impossible
        if (s.length() < t.length()) {
            return "";
        }

        // Stores the frequency of characters required from t
        Map<Character, Integer> need = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // Stores frequencies of characters in current window
        Map<Character, Integer> window = new HashMap<>();

        // Number of unique characters whose required frequency is satisfied
        int formed = 0;

        // Number of unique characters we need to satisfy
        int required = need.size();

        int left = 0;

        // Stores best answer found so far
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        // Expand the window by moving right
        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            // Add current character to window
            window.put(currentChar,
                    window.getOrDefault(currentChar, 0) + 1);

            /*
             * If this character is needed AND
             * its frequency in window exactly matches
             * the required frequency,
             * then one requirement is satisfied
             */
            if (need.containsKey(currentChar)
                    && window.get(currentChar).intValue()
                    == need.get(currentChar).intValue()) {

                formed++;
            }

            /*
             * When formed == required,
             * current window contains everything from t
             *
             * Now try shrinking from left
             * to make the window as small as possible
             */
            while (formed == required) {

                // Current window size
                int currentLen = right - left + 1;

                // Update answer if smaller window found
                if (currentLen < minLen) {
                    minLen = currentLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                // Remove left character from window
                window.put(leftChar,
                        window.get(leftChar) - 1);

                /*
                 * If removing this character causes
                 * its frequency to go below required,
                 * window becomes invalid
                 */
                if (need.containsKey(leftChar)
                        && window.get(leftChar)
                        < need.get(leftChar)) {

                    formed--;
                }

                // Shrink window
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLen);
    }
}