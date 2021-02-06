public class sqrt {
    public double sqrt(double n) { //wrapper
        double g = 1;
        while ((g*g)/n > 0.00001) { // checks the percent difference
            g = sqrtHelp(n, g);
        }
        return g;
    }
    private double sqrtHelp(double n, double guess) {
        return (n/(guess+guess))/2;
    }
}