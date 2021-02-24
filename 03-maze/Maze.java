import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
    public static char[][] readBoard(String filename) {
        try {
            File f = new File(filename);
            Scanner in = new Scanner(f);
            int lines = 0;
            int num = 0;
            String temp = "";
            while (in.hasNextLine()) {
                temp += in.nextLine();
                lines++;
            }
            num = temp.length()/lines;
            in.close();
            char[][] maze = new char[lines][num];
            for (int i = 0; i < lines; i++) {
                for (int j = 0; j < num; j++) {
                    maze[i][j] = temp.charAt(i*num+j);
                }
            }
            return maze;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return null;
    }

    public static void main(String args[]) {
        char[][] a = readBoard("Maze1.txt");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
