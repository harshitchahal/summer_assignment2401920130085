import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int len = temperatures.length;

        int[] result = new int[len];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < len; i++) {

            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {

                int index = st.pop();
                result[index] = i - index;
            }

            st.push(i);
        }

        return result;
    }
}