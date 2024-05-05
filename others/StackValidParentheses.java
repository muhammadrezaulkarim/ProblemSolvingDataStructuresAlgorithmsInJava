import java.util.*;

class StackValidParentheses {
    public boolean isValid(String s) {

        Stack<Character> st = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else if (c == ')') {
                // no matching '(' pushed earlier
                // peek() operation throws exception if the stack is empty
                if (!st.isEmpty() && st.peek() == '(')
                    st.pop();
                else
                    return false;
            }

            else if (c == '}') {
                // no matching '{' pushed earlier
                if (!st.isEmpty() && st.peek() == '{')
                    st.pop();
                else
                    return false;
            }

            else if (c == ']') {
                // no matching '{' pushed earlier
                if (!st.isEmpty() && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }
        }

        if (st.size() > 0)
            return false;
        else
            return true;

    }

    public static void main(String[] args) {
        StackValidParentheses ob = new StackValidParentheses();
        System.out.println(ob.isValid("()[]{}"));
        System.out.println(ob.isValid("]"));
        System.out.println(ob.isValid("(){}}{"));
    }
}

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

input: ()[]{}
output: true

input: ]
output: false

input: (){}}{
output: false
*/
