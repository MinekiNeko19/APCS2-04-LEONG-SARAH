import java.util.*;
import java.io.*;

public class USACO {
    public static int bronze(String filename) {
        try {
            // parse the file
            File f = new File(filename);
            Scanner in = new Scanner(f);
            int rows = in.nextInt();
            int cols = in.nextInt();
            int e = in.nextInt();
            int n = in.nextInt();
            if (rows <= 0 || cols <= 0 || e <= 0) return 0;

            int[][] elevation = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    elevation[i][j] = in.nextInt();
                }
            }
            // toString(elevation);
            int[][] instructions = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    instructions[i][j] = in.nextInt();
                }

                // to adjust the coordinates to match 2d array dimensions
                instructions[i][0] = instructions[i][0]-1;
                instructions[i][1] = instructions[i][1]-1;
            }
            in.close();
            // toString(instructions);

            // run the instructions
            for (int i = 0; i < instructions.length; i++) { // what instruction we are on
                int highest = 0;
                // find the highest elevation
                for (int y = instructions[i][0]; y <= instructions[i][0]+2; y++) { //row
                    for (int x = instructions[i][1]; x <= instructions[i][1]+2; x++) { // col
                        if (elevation[y][x] > highest) {
                            highest = elevation[y][x];
                        }
                    }
                }
                // System.out.println("Original tallest: " + highest);
                // change all the values to be level or lower
                highest = highest - instructions[i][2];
                if (highest < 0) highest = 0;
                // System.out.println("New tallest: " + highest);

                for (int y = instructions[i][0]; y <= instructions[i][0]+2; y++) { //row
                    for (int x = instructions[i][1]; x <= instructions[i][1]+2; x++) { // col
                        if (elevation[y][x] > highest) {
                            elevation[y][x] = highest;
                        }
                    }
                }
                // toString(elevation);
            }

            // obtain aggregated depth
            int depth = 0;
            for (int i = 0; i < elevation.length; i++) {
                for (int j = 0; j < elevation[0].length; j++) {
                    int temp = e - elevation[i][j];
                    if (temp > 0) {
                        depth += temp;
                    }
                }
            }
            // System.out.println(depth);
            return depth * 72 * 72;

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return 0;
        }
    }

    public static long silver(String filename) {
        try {
            // parse info
            File f = new File(filename);
            Scanner in = new Scanner(f);
            int rows = in.nextInt();
            int cols = in.nextInt();
            int moves = in.nextInt();
            long[][] numBessies = new long[rows][cols];
            char[][] map = new char[rows][cols];
            
            for (int i = 0; i < rows; i++) {
                String temp = in.next();
                for (int j = 0; j < cols; j++) {
                    map[i][j] = temp.charAt(j);
                    if (temp.charAt(j)=='*') numBessies[i][j] = -1;
                }
            }
            // toString(map);
            int sy = in.nextInt()-1;
            int sx = in.nextInt()-1;
            int ey = in.nextInt()-1;
            int ex = in.nextInt()-1;
            in.close();

            // move from start to end
            map[sy][sx]='b';
            for (int i = 0; i < moves; i++) { // counts steps/seconds
                //change numBessies accordingly
                for (int y = 0; y < rows; y++) {
                    for (int x = 0; x < cols; x++) {
                        if (map[y][x]=='b'  && map[y][x]!='*') {
                            numBessies[y][x] = 0;
                            if (y-1 >= 0 && map[y-1][x]!='*') {
                                numBessies[y-1][x] += 1;
                            }
                            if (y+1 < rows && map[y+1][x]!='*') {
                                numBessies[y+1][x] += 1;
                            }
                            if (x-1 >= 0 && map[y][x-1]!='*') {
                                numBessies[y][x-1] += 1;
                            }
                            if (x+1 < cols && map[y][x+1]!='*'){
                                numBessies[y][x+1] += 1;
                            }
                            map[y][x] = '.';
                        }
                    }
                }

                //change map accordingly
                for (int y = 0; y < rows; y++) {
                    for (int x = 0; x < cols; x++) {
                        if (numBessies[y][x] > 0) {
                            map[y][x] = 'b';
                        }
                    }
                }

                // Seeing the 2d arrs
                // System.out.println("Time: " + (i + 1) + " seconds passed");
                // System.out.println("Map");
                // toString(map);
                // System.out.println("numBessies");
                // toString(numBessies);
            }          
            return numBessies[ey][ex];
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
        return 0;
    }

    private static void toString(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    private static void toString(long[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
