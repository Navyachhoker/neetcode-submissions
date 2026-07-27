class MinStack {
    
    Stack<Integer> s ;
    Stack<Integer> min ;

    public MinStack() {
            s = new Stack<>();
            min = new Stack<>();
        
    }
    
    public void push(int val) {
        s.push(val);

        if(min.isEmpty()){
            min.push(val);
        }
        else{
            min.push(Math.min(val, min.peek()));
        }
    }
    
    public void pop() {
        s.pop();
        min.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
