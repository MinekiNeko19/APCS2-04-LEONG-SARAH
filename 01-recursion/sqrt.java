public class sqrt {
    public static double sqrtNewton(double n) { //wrapper
        double g = 1;
        g = guessHelp(n, g);
        return g;
    }
    private static double guessHelp(double n, double guess) {
        if (Math.abs(guess*guess - n) <= n*0.00001) {
            return guess;
        } else {
            return guessHelp(n, (n/guess+guess)/2);
        }
    }

    // public static void main(String[] args) {
    //     System.out.println(sqrtNewton(100));
    // }
}