public class sqrt {
    public static double sqrtNewton(double n) { //wrapper
        double g = 1;
        while ((g*g)/n > 0.00001) { // checks the percent difference
            g = guessHelp(n, g);
        }
        return g;
    }
    private static double guessHelp(double n, double guess) {
        return (n/(guess+guess))/2;
    }
}