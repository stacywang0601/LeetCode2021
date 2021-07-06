import java.util.Stack;

/*
 * 2021-05-04 Tue
 * Use an additional array to record the increment value.
 * inc[i] means for all i elements stack[0] ~ stack[i-1],
 * total n elements, inc[n] --> so inc has length of n+1
 * We should plus inc[i] when popped from the stack.
 * then inc[i-1]+=inc[i],
 * so that we can accumulate the increment inc[i]
 * for the bottom elements and the following pops.
 */
class CustomStack {
    int n;
    int[] inc;
    Stack<Integer> stack;

    public CustomStack(int maxSize) {
        this.n = maxSize;
        stack = new Stack<>();
        inc = new int[n + 1];
    }

    public void push(int x) {
        if (stack.size() < n) {
            stack.push(x);
        }
    }

    public int pop() {
        int i = stack.size();
        if (i <= 0) {
            return -1;
        }

        inc[i - 1] += inc[i];
        int res = stack.pop() + inc[i];
        inc[i] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size());
        inc[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
}
