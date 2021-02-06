import java.lang.ArithmeticException;

public class sqrt {
    public static double sqrtNewton(double n) { //wrapper
        if (n<0) throw new ArithmeticException();
        double g = 1;
        g = guessHelp(n, g);
        return g;
    }
    private static double guessHelp(double n, double guess) {
        if (n == 0) return 0;
        if (Math.abs(guess*guess - n) <= n*0.00001) {
            return guess;
        } else {
            return guessHelp(n, (n/guess+guess)/2);
        }
    }
}