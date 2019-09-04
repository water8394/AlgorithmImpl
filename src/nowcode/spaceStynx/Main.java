package nowcode.spaceStynx;

import java.util.Scanner;
import java.util.Stack;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static String resolve(String expr) {

        String res = "";
        Stack<Character> space = new Stack<>();
        Stack<Character> stack = new Stack<>();
        char[] arr = expr.toCharArray();
        for (int i = 0; i < expr.length(); i++) {
            char c = arr[i];
            if (c == '('){
                space.push(c);
            }else if (c == ')'){
                if (space.isEmpty() || space.size()<1) return "";
                else{
                    space.pop();
                    String tmp = "";
                    while (!stack.isEmpty()){
                        tmp += stack.pop();
                    }
                    if (space.isEmpty()){
                        res += tmp;
                    }else {
                        for (char t : tmp.toCharArray()){
                            stack.push(t);
                        }
                    }
                }
            }else {
                if (space.isEmpty()){
                    String tmp ="";
                    while (!stack.isEmpty()){
                        tmp += stack.pop();
                    }
                    res += tmp + c;
                }else{
                stack.push(c);
                }
            }
        }
        if (!space.isEmpty()) return "";
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _expr;
        try {
            _expr = in.nextLine();
        } catch (Exception e) {
            _expr = null;
        }

        res = resolve(_expr);
        System.out.println(res);
    }
}
