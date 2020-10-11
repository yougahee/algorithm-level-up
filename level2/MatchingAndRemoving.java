package level2;

import java.util.Stack;

public class MatchingAndRemoving {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }

    //stack을 생각하지 못했던 문제..
    //알고보면 너무 간단한 건데 stack을 활용하는 것을 파악하지 못했다
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
