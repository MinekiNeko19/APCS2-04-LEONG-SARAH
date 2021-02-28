import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.
        When the file is not found then:
            throw a FileNotFoundException

        You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
        '#' - Walls - locations that cannot be moved onto
        ' ' - Empty Space - locations that can be moved onto
        'E' - the location of the goal (exactly 1 per file)
        'S' - the location of the start(exactly 1 per file)

        You may also assume the maze has a border of '#' around the edges.
        So you don't have to check for out of bounds!
    */
    public Maze(String filename) throws FileNotFoundException{
        animate = true;
        ArrayList<String> lines = new ArrayList<String>();

        try {
            File f = new File(filename);
            Scanner in = new Scanner(f);
            while (in.hasNextLine()) {
                lines.add(in.nextLine());
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        
        maze = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            maze[i] = lines.get(i).toCharArray();
        }
    }

    private void wait(int millis){
            try {
                Thread.sleep(millis);
            }
            catch (InterruptedException e) {
            }
        }

    public void setAnimate(boolean b){
        animate = b;
    }

    public static void clearTerminal(){
        //erase terminal
        System.out.println("\033[2J");
    }
    public static void gotoTop(){
        //go to top left of screen
        System.out.println("\033[1;1H");
    }

    /*Return the string that represents the maze.
        It should look like the text file with some characters replaced.
    */
    public String toString(){
        String board = "";
        if (maze.length <= 0) return board;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                board+= maze[i][j];
            }
            board += "\n";
        }
        return board;
    }

    /*Wrapper Solve Function returns the helper function
        Note the helper function has the same name, but different parameters.
        Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public int solve(){
        //only clear the terminal if you are running animation
        if(animate){
            clearTerminal();
        }

        //start solving at the location of the s.
        //return solve(???,???);
        for (int i = 0; i < maze.length;i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j]=='S') {
                    maze[i][j]='@';
                    return solve(i,j);
                }
            }
        }

        return 0;
    }

    /*
        Recursive Solve function:

        A solved maze has a path marked with '@' from S to E.

        Returns the number of @ symbols from S to E when the maze is solved,
        Returns -1 when the maze has no solution.

        Postcondition:
        The 'S' is replaced with '@'
        The 'E' remain the same
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col){ //you can add more parameters since this is private
        //automatic animation! You are welcome.
        if(animate){
            gotoTop();
            System.out.println(this);
            wait(50);
        }

        int count = 1; // adds current position to count
        boolean noSpace = false;

        // base case: E is found
        if (maze[row][col]=='E') {
            return count-1;
        }
        // recursion if spaces: order of checking WNES
        maze[row][col] = '@';
        if (maze[row-1][col]==' ' || maze[row-1][col]=='E') { // left
            return count += solve(row-1,col);
        } else
        if (maze[row][col+1]==' ' || maze[row][col+1]=='E') { // up
            return count += solve(row,col+1);
        } else
        if (maze[row+1][col]==' ' || maze[row+1][col]=='E') { // right
            return count += solve(row+1,col);
        } else
        if (maze[row][col-1]==' ' || maze[row][col-1]=='E') { // down
            return count += solve(row,col-1);
        } else {
            noSpace = true;
        }

        // won't always take the most efficient path ex.:
        // end is west but south is also empty
        // empty rectangle with S in top right and E in bottom left

        if (noSpace) {
            count=-1; // subtract the extra step
            maze[row][col] = '.';
            // find the last step
            if (maze[row-1][col]=='@') { // left
                return count += solve(row-1,col);
            }
            if (maze[row][col+1]=='@') { // up
                return count += solve(row,col+1);
            }
            if (maze[row+1][col]=='@') { // right
                return count += solve(row+1,col);
            }
            if (maze[row][col-1]=='@') { // down
                return count += solve(row,col-1);
            }
        }

        return -1; //so it compiles
    }


    

    public Maze(int rows, int cols) { // constructor for char[][] boards
        maze = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0;j < cols; j++) {
                maze[i][j] = '#';
            }
        }
        animate = false;

        // int startR = (int)(Math.random() * (cols-2) + 1);
        // int startC = (int)(Math.random() * (cols-2) + 1);
        int startR = 8;
        int startC = 8;

        System.out.println(startR + ", " + startC);

        MazeCarve(startR, startC);
    }

    private boolean safe(int row, int col) {
        if (row == 0 || row == maze.length-1) return false;
        if (col == 0 || col == maze[row].length-1) return false;
        int walls = 0;
        if (maze[row-1][col] == '#') { // up 0
            walls++;
        }
        if (maze[row+1][col] == '#') { // down 1
            walls++;
        }
        if (maze[row][col+1] == '#') { // right 2
            walls++;
        }
        if (maze[row][col-1] == '#') { // left 3
            walls++;
        }
        return walls >= 3;
    }

    private void MazeCarve(int row, int col) {
        maze[row][col] = ' ';

        // int[] safeBranch = new int[]{0,0,0,0,0};
        // if (safe(row-1, col)) {
        //     safeBranch[0] = 1;
        // } 
        // if (safe(row+1, col)) {
        //     safeBranch[1] = 1;
        // }
        // if (safe(row, col+1)) {
        //     safeBranch[2] = 1;
        // }
        // if (safe(row, col-1)) {
        //     safeBranch[3] = 1;
        // }
        System.out.println(toString());

        for (int i = 0; i < 4; i++) {
            int path = (int)(Math.random() * 5);
            if (path == 0 && safe(row-1,col)) {
                MazeCarve(row-1, col);
            }
            if (path == 1 && safe(row+1,col)) {
                MazeCarve(row+1, col);
            }
            if (path == 2 && safe(row,col+1)) {
                MazeCarve(row, col+1);
            }
            if (path == 3 && safe(row,col-1)) {
                MazeCarve(row, col-1);
            }
        }
    }
}
