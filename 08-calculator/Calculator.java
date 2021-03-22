import java.util.*;

public class Calculator {
    public static double eval(String s){
        Scanner line = new Scanner(s);
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        while (line.hasNext()) {
            String current = line.next();
            System.out.println(current);
            if (current.equals("*")) {
                stack.addFirst(0.0); // place holder
            }
            else if (current.equals("/")) {
                stack.addFirst(0.0); // place holder
            }
            else if (current.equals("+")) {
                Double a = stack.removeFirst();
                Double b = stack.removeFirst();
                stack.addFirst(a+b);
            }
            else if (current.equals("-")) {
                stack.addFirst(0.0); // place holder
            } else {
                stack.addFirst(Double.parseDouble(current));
            }
        }
        System.out.println(stack.toString());
        return stack.getLast();
    }
}
