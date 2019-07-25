package com.lugew.datastructure.study.stack;

import com.lugew.datastructure.util.Stack;

/**
 * 栈实现的字符串反转
 */
public class Reverser {
    public static String reverse(String input) {
        int stackSize = input.length();
        Stack<Character> stack = new ArrayStack<Character>(stackSize);
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }
        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }
        return output.toString();
    }
}
