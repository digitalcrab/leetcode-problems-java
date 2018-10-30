import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */

public class ValidParentheses {

    /**
     * Time complexity : O(n) because we simply traverse the given string one character at a time and push
     * and pop operations on a stack take O(1)O(1) time.
     * <p>
     * Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case,
     * we will end up pushing all the brackets onto the stack.
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        HashMap<Character, Character> p = new HashMap<>();
        p.put('{', '}');
        p.put('(', ')');
        p.put('[', ']');

        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (p.containsKey(c)) { // open
                st.push(p.get(c)); // lest push closed bracket to the stack
            } else { // close
                // we've got unexpected bracket
                if (st.empty() || !st.pop().equals(c)) {
                    return false;
                }
            }
        }

        return st.empty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();

        System.out.println(vp.isValid("()")); // true
        System.out.println(vp.isValid("()[]{}")); // true
        System.out.println(vp.isValid("(]")); // false
        System.out.println(vp.isValid("([)]")); // false
        System.out.println(vp.isValid("{[]}")); // true
        System.out.println(vp.isValid("]")); // false
    }
}
