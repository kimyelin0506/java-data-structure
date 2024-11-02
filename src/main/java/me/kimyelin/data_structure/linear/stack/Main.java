package me.kimyelin.data_structure.linear.stack;

import java.util.Stack;

import static me.kimyelin.Main.line;

// 선형 자료구조 - 스택
public class Main {
    public static void main(String[] args){
        Stack stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        line();

        System.out.println(stack.pop());
        System.out.println(stack);
        line();

        stack.pop();
        System.out.println(stack);
        line();

        System.out.println("top을 출력해주지만 Pop은 하지않음(peek): "+stack.peek());
        System.out.println(stack);
        line();

        System.out.println("contains: "+stack.contains(1));
        line();

        System.out.println("size: "+stack.size());
        line();

        System.out.println("empty: "+stack.empty());
        line();

        stack.clear();  // null -> EmptyStackException
        System.out.println(stack);
    }
}
