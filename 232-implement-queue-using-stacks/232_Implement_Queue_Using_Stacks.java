class MyQueue {
    Stack<Integer> first;
    Stack<Integer> second;

    public MyQueue() {
        first = new Stack<>();
        second = new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    void shiftifneeded(){
        if(second.isEmpty()){
            while(!first.isEmpty()){
                second.push(first.pop());
            }
        }
    }
    
    public int pop() {
        shiftifneeded();
        return second.pop();
    }
    
    public int peek() {
        shiftifneeded();
        return second.peek();
    }
    
    public boolean empty() {
        return (first.isEmpty() && second.isEmpty());
    }
}

// class MyQueue {
//     private Stack<Integer> first;
//     private Stack<Integer> second;

//     public MyQueue() {
//         first = new Stack<>();
//         second = new Stack<>();
//     }

//     public void push(int x) {
//         first.push(x);
//     }

//     private void shiftIfNeeded() {
//         if (second.isEmpty()) {                 // or: while (!first.empty())
//             while (!first.isEmpty()) {
//                 second.push(first.pop());       // pop()/push()/peek() are methods
//             }
//         }
//     }

//     public int pop() {
//         shiftIfNeeded();
//         return second.pop();                    // remove + return front
//     }

//     public int peek() {
//         shiftIfNeeded();
//         return second.peek();                   // look at front without removing
//     }

//     public boolean empty() {
//         return first.isEmpty() && second.isEmpty();
//     }
// }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */