public class MazeGenerator {
    public static void generate(char[][] maze) {
        if (maze.length != 0 && maze[0].length != 0) {

            int startR = (int)(Math.random() * (maze.length-2) + 1);
            int startC = (int)(Math.random() * (maze[0].length-2) + 1);

            // System.out.println(startR + ", " + startC);

            MazeCarve(maze, startR, startC);
        }
    }
    
    private static boolean safe(char[][] maze, int row, int col) {
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

    private static void MazeCarve(char[][] maze, int row, int col) {
        maze[row][col] = ' ';
        boolean[] checked = new boolean[]{false,false,false,false};

        while (!(checked[0] && checked[1] && checked[2] && checked[3])) {
            int path = (int)(Math.random() * 4);
            while (checked[path]) {
                path = (int)(Math.random() * 4);
            }

            if (path == 0) { // up
                checked[0]=true;
                if (safe(maze, row-1,col)) {
                    MazeCarve(maze, row-1, col);
                }
            }
            if (path == 1) { // down
                checked[1]=true;
                if (safe(maze, row+1,col)) {
                    MazeCarve(maze, row+1, col);
                }
            }
            if (path == 2) { // right
                checked[2]=true;
                if (safe(maze, row,col+1)) {
                    MazeCarve(maze, row, col+1);
                }
            }
            if (path == 3) { // left
                checked[3]=true;
                if (safe(maze, row,col-1)) {
                    MazeCarve(maze, row, col-1);
                }
            }
        }
    }

}
