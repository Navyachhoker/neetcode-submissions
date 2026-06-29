class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length())
              .append('#')
              .append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            int j = i;

            // find '#'
            while (str.charAt(j) != '#') {
                j++;
            }

            // length before '#'
            int len = Integer.parseInt(str.substring(i, j));

            // actual string
            String word = str.substring(j + 1, j + 1 + len);

            result.add(word);

            // move to next encoded string
            i = j + 1 + len;
        }

        return result;
    }
}