public class RecursionTester {
    public static void main(String[] args) {
        System.out.println("Testing Reverse");
        System.out.println(Recursion.reverse("abcdefg"));
        System.out.println(Recursion.reverse(""));

        System.out.println("Testing countNoDoubleLetterWords");
        System.out.println(Recursion.countNoDoubleLetterWords(2,""));
    }
}