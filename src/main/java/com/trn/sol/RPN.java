package com.trn.sol;

import java.util.Stack;

public class RPN {

    public static int evalRPN(String[] tokens) {

        if(tokens.length == 0){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){

                Integer num2 = stack.pop();
                Integer num1 = stack.pop();

                Integer result = evaluate(token, num1, num2);
                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static Integer evaluate(String token, Integer num1, Integer num2){
        switch(token) {
            case "+" :
                return num1 + num2;
            case "-" :
                return num1 - num2;
            case "*" :
                return num1 * num2;
            case "/" :
                return num1 / num2;

        }

        return -555;
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"4", "13", "5", "/", "+"};

        int result = evalRPN(tokens);

        System.out.println("Result => "+ result);

    }
}
