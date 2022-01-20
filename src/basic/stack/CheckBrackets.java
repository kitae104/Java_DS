package basic.stack;

import java.util.Stack;

// 스택을 이용한 괄호 개수 체크하기
public class CheckBrackets{
    public static void main(String[] args) {
        String inputStr = "{ ( [ ( ] ) }";
        String[] tokens = inputStr.split(" ");
        
        Stack<String> stack = new Stack<>();

        for (String str : tokens) {
            System.out.println(str);
            if(str.equals("{") || str.equals("[") || str.equals("(")){
                stack.push(str);
            } else if(str.equals("}")){
                if(stack.peek().equals("{")){
                    stack.pop();
                } else {
                    System.out.println(str + "오류 발생 : " + stack.peek());
                    break;
                }
            } else if(str.equals("]")){
                if(stack.peek().equals("[")){
                    stack.pop();
                } else {
                    System.out.println(str + "오류 발생 : " + stack.peek());
                    break;
                }
            } else if(str.equals(")")){
                if(stack.peek().equals("(")){
                    stack.pop();
                } else {
                    System.out.println(str + "오류 발생 : " + stack.peek());
                    break;
                }
            } else {
                System.out.println("체크 필요!!");
            }
        }

        if(stack.isEmpty()){
            System.out.println("성공");
        } else {
            System.out.println("쌍이 맞지 않음");
        }
    }
}