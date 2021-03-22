import java.util.*;

public class Calculator {
    public static double eval(String s){
        StringTokenizer line = new StringTokenizer(s);
        while (line.hasMoreTokens()) {
            System.out.println(line.nextToken());
        }
        return 0;
    }
}
