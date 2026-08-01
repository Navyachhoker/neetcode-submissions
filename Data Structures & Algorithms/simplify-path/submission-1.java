class Solution {
    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        String[] parts = path.split("/");
        for(String p : parts){
            if(p.equals("")||p.equals(".")){
                continue;
            }
            else if (p.equals("..")){
               if(!s.isEmpty())
               { s.pop();}
            }
            else{
                s.push(p);
            }
        }
        if (s.isEmpty()) {
            return "/";
        }
        StringBuilder result = new StringBuilder();
        for (String dir : s) {
            result.append("/").append(dir);
        }

        return result.toString();
    }
}