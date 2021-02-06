public class Recursion {
    public static String reverse(String s) {
        if (s.length()<=1) { // base case
            return s;
        } else {
            return reverse(s.substring(1)) + s.charAt(0);
        }
    }

    public static long countNoDoubleLetterWords(int length, String word) {
        int count = 0; // keeps track of words in each case
        if (length==0) return 0; // special case
        if (word.length()==length) { // base case
            count++;
        } else {
            for (int i = 97; i < 123; i++) { // (char)97 is 'a'
                if (word.length()==0 || (int)word.charAt(word.length()-1) != i) {
                    // telescope add the counts
                    count += countNoDoubleLetterWords(length, word+(char)i);
                } // no else statement to cut off the branches with repeats
            }
        }
        return count;
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
