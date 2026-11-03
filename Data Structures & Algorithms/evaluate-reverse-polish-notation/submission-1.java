class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if(s.equals("+")){
                int sum = stack.pop()+stack.pop();
                stack.push(sum);

            }
            else if(s.equals("-")){
                int diff = (-stack.pop()) + stack.pop();
                stack.push(diff);
                
            }
            else if(s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
                
            }
            else if(s.equals("*")){
                int prod = stack.pop()*stack.pop();
                stack.push(prod);
                
            }
            else{
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.peek();
    }
}
