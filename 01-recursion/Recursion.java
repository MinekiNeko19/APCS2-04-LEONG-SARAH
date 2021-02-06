public class Recursion {
    public static String reverse(String s) {
        return "";
    }

    public static long countNoDoubleLetterWords(int length, String word) {
        return 0;
    }

    public static double sqrt(double n) { //wrapper
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
