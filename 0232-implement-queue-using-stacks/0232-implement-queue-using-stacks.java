class MyQueue {
    private Stack<Integer> s1, s2;
    int front;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    // Push element x to the back of queue.
    public void push(int x) {
        if (s1.empty()) front = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) s2.push(s1.pop());
        }
        return s2.pop();
    }

    // Get the front element.
    public int peek() {
        if (!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
