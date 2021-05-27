package lesson3;

import lesson3.stack.Stack;
import lesson3.stack.StackImpl;

public class StringRevertApp {

    public static void main(String[] args) {
        String text = "1234567890abcd";

        System.out.println(text + " => reverted => " + revertText(text));
    }

    public static String revertText(String text) {
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
