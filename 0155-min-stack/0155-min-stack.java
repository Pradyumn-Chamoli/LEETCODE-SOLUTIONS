class MinStack {

    private Stack<Long> st ;
    private long mini;

    public MinStack() {
        st = new Stack<>();
        
    }

    public void push(int val) {
        if(st.empty()){
            st.push((long)val);
            mini = val;
            return;
        }

        if(val>=mini){
            st.push((long)val);
        }else{
            st.push(2L*val-mini);
            mini = val;
        }
    }

    public void pop() {
        if(st.empty()){
            return;
        }

        long x = st.pop();

        if(x<mini){
            mini = 2*mini-x;
        }

    }

    public int top() {
        if(st.empty()) return -1;

        long x = st.peek();

        if(mini<=x) return (int) x;

        return (int)mini;
    }

    public int getMin() {
        if(st.empty()) return -1;
        return (int)mini;
        
    }
}