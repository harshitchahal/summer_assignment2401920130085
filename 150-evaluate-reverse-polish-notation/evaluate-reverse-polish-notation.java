import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for (String str : tokens) {

            if (str.equals("+") || str.equals("-") ||
                str.equals("*") || str.equals("/")) {

                int num1 = st.pop();
                int num2 = st.pop();

                switch (str) {
                    case "+":
                        st.push(num2 + num1);
                        break;

                    case "-":
                        st.push(num2 - num1);
                        break;

                    case "*":
                        st.push(num2 * num1);
                        break;

                    case "/":
                        st.push(num2 / num1);
                        break;
                }

            } else {
                st.push(Integer.parseInt(str));
            }
        }

        return st.peek();
    }
}