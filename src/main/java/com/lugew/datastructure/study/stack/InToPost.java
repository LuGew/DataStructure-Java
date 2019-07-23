package com.lugew.datastructure.study.stack;

public class InToPost {
    private Stack<Character> stack;
    private StringBuilder output = new StringBuilder();

    public String transfer(String input) {
        int stackSize = input.length();
        stack = new Stack<Character>(stackSize);
        output = new StringBuilder();
        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            System.out.print("For " + ch + " ");
            stack.display();
            switch (ch) {
                case '+':
                case '-':
                    getOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    getOperator(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    getParent(ch);
                    break;
                default:
                    output.append(ch);
                    break;

            }
        }

        while (!stack.isEmpty()) {
            stack.display();
            output.append(stack.pop());
        }
        stack.display();
        return output.toString();
    }

    private void getOperator(char opThis, int prec1) {
        while (!stack.isEmpty()) {
            char opTop = stack.pop();
            if (opTop == '(') {
                stack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stack.push(opTop);
                    break;
                } else {
                    output.append(opTop);
                }

            }

        }
        stack.push(opThis);
    }


    public void getParent(char ch) {
        while (!stack.isEmpty()) {
            char chx = stack.pop();
            if (chx == '(') {
                break;
            } else {
                output.append(chx);
            }
        }
    }
}
