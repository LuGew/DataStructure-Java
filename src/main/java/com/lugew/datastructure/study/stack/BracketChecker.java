package com.lugew.datastructure.study.stack;

public class BracketChecker {
    public static void check(String input) {
        int size = input.length();
        Stack<Character> stack = new Stack<Character>(size);
        for (int i = 0; i < size; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stack.isEmpty()) {
                        char chx = stack.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')
                        ) {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    } else {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
