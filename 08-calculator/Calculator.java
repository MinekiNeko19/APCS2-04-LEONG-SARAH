import java.util.*;


public class Calculator {
    public static double eval(String s){
        if (s.equals("")) throw new IllegalArgumentException("Nothing to calculate (empty)"); // change if unneeded

        Scanner line = new Scanner(s);
        ArrayDeque<Double> stack = new ArrayDeque<Double>();
        while (line.hasNext()) {
            String current = line.next();
            // System.out.println(current);
            if (current.equals("*")) {
                if (stack.size() < 2) throw new IllegalArgumentException("Too many operands");
                Double a = stack.removeFirst();
                Double b = stack.removeFirst();
                stack.addFirst(a*b);
            }
            else if (current.equals("/")) {
                if (stack.size() < 2) throw new IllegalArgumentException("Too many operands");
                Double a = stack.removeFirst();
                Double b = stack.removeFirst();
                stack.addFirst(b/a);
            }
            else if (current.equals("+")) {
                if (stack.size() < 2) throw new IllegalArgumentException("Too many operands");
                Double a = stack.removeFirst();
                Double b = stack.removeFirst();
                stack.addFirst(a+b);
            }
            else if (current.equals("-")) {
                if (stack.size() < 2) throw new IllegalArgumentException("Too many operands");
                Double a = stack.removeFirst();
                Double b = stack.removeFirst();
                stack.addFirst(b-a);
            }
            else if (current.equals("%")) {
                if (stack.size() < 2) throw new IllegalArgumentException("Too many operands");
                Double a = stack.removeFirst();
                Double b = stack.removeFirst();
                stack.addFirst(b%a);
            }
            else {
                stack.addFirst(Double.parseDouble(current));
            }
            // System.out.println(stack.toString());
        }
        line.close();
        if (stack.size() != 1) throw new IllegalArgumentException("Too few operands");
        return stack.getLast();
    }
}
