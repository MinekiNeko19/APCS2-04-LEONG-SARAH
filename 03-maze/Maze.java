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
        animate = false;
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

    public static char[][] MazeGenerator(int row, int col) {
        char[][] maze = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0;j < col; j++) {
                maze[i][j] = '#';
            }
        }
        return maze;
    }
}
