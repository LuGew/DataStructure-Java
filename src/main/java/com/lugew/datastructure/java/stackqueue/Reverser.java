package com.lugew.datastructure.java.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev() {
        int stackSize = input.length();
        StackX stackX = new StackX(stackSize);
        for (int i = 0; i < input.length(); i++) {
            stackX.push(input.charAt(i));
        }
        output = "";
        while (!stackX.isEmpty()) {
            output += stackX.pop();
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter a string: ");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            Reverser reverser = new Reverser(input);
            output = reverser.doRev();
            System.out.println("Revered: " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        return s;
    }
}
