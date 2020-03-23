import java.util.Stack;

/**
 * Created by Dmitriy on 11.11.2019.
 */
public class Task15 {
    final static String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+ -+r+u--+l+e+s---";

    public static void main(String[] args) {
        boolean plus = false;

        Stack<Character> chars = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            switch (ch) {
                case '+' :
                    plus = true;
                    break;
                case '-' :
                    plus = false;
                    System.out.print(chars.pop());
                    break;
                default:
                    if(plus) {
                        chars.push(ch);
                    }
            }
        }
    }
}
