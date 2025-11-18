package com.javastack.datastructures.stacksqueues;

import java.util.Stack;

public class ValidParenthesisUsingStack {

    public static void main(String[] args) {
        System.out.println(ValidParenthesisUsingStack.isValid("()"));      // true
        System.out.println(ValidParenthesisUsingStack.isValid("()[]{}"));  // true
        System.out.println(ValidParenthesisUsingStack.isValid("(]"));      // false
        System.out.println(ValidParenthesisUsingStack.isValid("([)]"));    // false
        System.out.println(ValidParenthesisUsingStack.isValid("{[]}"));    // true
    }
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch=='(' || ch=='{' || ch=='[')
             {
                stack.push(ch);
            }
            else
            {
                if(stack.size()==0) return false;
                char top = stack.pop();
                if(ch==')' && top!='(') return false;
                if(ch=='}' && top!='{') return false;
                if(ch==']' && top!='[') return false;
            }
        }

        if (stack.size() > 0) return false;
        return true;
    }
}
