package zadachi;

public class Stack {


    public void D() {
        java.util.Stack<String> stack = new java.util.Stack<>();
        String s = "[]}(){[]((";
        String[] s1 = s.split("");


        for (int i = 0; i <= s1.length - 1; i++) {
            if (s1[i].equals("[") || s1[i].equals("{") || s1[i].equals("(")) {  // если ")" , то не добавит даже еслт она в середине, т.к. с нее не может начинаться
                stack.push(s1[i]);
            } else if (stack.empty()) {
                System.out.println(" erooorrr"); // если ")" ,то пустой стэк, т.к. не правильно априори
            }

            if (!stack.empty() && s1[i].equals("]") || !stack.empty() && s1[i].equals("}") || !stack.empty() && s1[i].equals(")")) {
                stack.pop();
            }

        }

        if(!stack.empty()) {
            System.out.println("error"+stack.size());
        }
    }

    public void d() {
        java.util.Stack<Character> s = new java.util.Stack<>();
        String c = "[]}(){[]((";
        char[] c1 = c.toCharArray();


        for (int i = 0; i <= c1.length - 1; i++) {
            if (c1[i]=='[' || c1[i]=='{' || c1[i]=='(') {  // если ")" , то не добавит даже еслт она в середине, т.к. с нее не может начинаться
                s.push(c1[i]);
            } else if (s.empty()) {
                System.out.println(" erooorrr"); // если ")" ,то пустой стэк, то не правильно априори
            }

            if (!s.empty() && c1[i]==']' || !s.empty() && c1[i]=='}' || !s.empty() && c1[i]==')') {
                s.pop();
            }
        }
        if(!s.empty()) {
            System.out.println("error"+s.size());
        }
    }
}
