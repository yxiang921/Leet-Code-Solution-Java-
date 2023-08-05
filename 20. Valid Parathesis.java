import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "({}";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int length = s.length();
        char[] strArray = s.toCharArray();

        if(length == 0){ return true;}

        Stack<Character> stackList = new Stack<>();

        for(int i = 0; i < length; i++){

            if(strArray[i] == '(' || strArray[i] == '{' || strArray[i] == '['){
                stackList.push(strArray[i]);
            } else if (!stackList.empty() && strArray[i] == ')' && stackList.peek() == '(') {
                stackList.pop();
            } else if (!stackList.empty() && strArray[i] == '}' && stackList.peek() == '{') {
                stackList.pop();
            } else if (!stackList.empty() && strArray[i] == ']' && stackList.peek() == '[') {
                stackList.pop();
            } else {
                return false;
            }

        }

        return stackList.empty();
    }
}
