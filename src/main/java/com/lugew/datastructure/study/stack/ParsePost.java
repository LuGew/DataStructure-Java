package com.lugew.datastructure.study.stack;

public class ParsePost {
    public static int parse(String input) {
        Stack<Integer> stack = new Stack<Integer>(20);
        char ch;
        int j;
        int num1, num2, result;
        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            if (ch >= '0' && ch <= '9') {
                stack.push((int) (ch - '0'));
            } else {
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    default:
                        result = 0;
                }
                stack.push(result);
            }
        }
        result = stack.pop();
        return result;
    }

}

