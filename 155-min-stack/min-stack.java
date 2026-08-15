class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minSt.size()==0 || val < minSt.peek()) minSt.push(val);
        else minSt.push(minSt.peek());
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    public int top() { // peek
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}

// class MinStack {
//     Stack<Long> st;
//     long min;
//     public MinStack() {
//         st = new Stack<>();
//         min = Long.MAX_VALUE;
//     }
    
//     public void push(int val) {
//         long value = (long)val;
//         if(st.size()==0) min = value;

//         if(value >= min) st.push(value);
//         else{ // val<min, stack me fake value daalo
//             st.push(value + (value-min));
//             min = value;
//         }
//     }
    
//     public void pop() {
//         if(st.peek() < min){ // locha hai, minimum roll back karo
//             min = min + (min - st.peek());
//         }
//         st.pop();
//     }
    
//     public int top() { // peek
//         long peek = st.peek();
//         if(peek < min){ // locha hai, minimum roll back karo
//             return (int)min;
//         }
//         else return (int)peek;
//     }
    
//     public int getMin() {
//         return (int)min;
//     }
// }
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */