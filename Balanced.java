import java.util.Stack;

public class Balanced {
    public static void main(String[] args) {
        String[] str = {"({[]})", "({[})", "((()))", "({)}"};
        for (String s : str)
            System.out.println(isBalanced(s));
    }

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Check closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
