public class Test {
    public static void main(String[] args) {
        MyStack<Integer> stack1 = new MyStack<>();
        MyStack<String> stack2 = new MyStack<>();
        //push test
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.toString());

        stack2.push("虎年");
        stack2.push("大吉");
        System.out.println(stack2.toString());

        //peek test
        System.out.println(stack1.peek());
        System.out.println(stack2.peek());

        //pop test empty test
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.empty());

        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.empty());
    }
}
