package level2;

import java.util.Stack;

public class MatchingAndRemoving {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for(char i : s.toCharArray()) {
            if(!stack.isEmpty() && i == stack.peek()) stack.pop();
            else stack.push(i);
        }

        return stack.isEmpty() ? 1: 0;
    }
}
