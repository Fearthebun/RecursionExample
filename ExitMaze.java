/**
 * <p>
 * Exits a maze
 * </p>
 *
 * @author Nayaab Ali
 * @version 1.0, April 15, 2019
 */
public class ExitMaze {
    
    /*
     * finds the entrance of the maze
     * @param m int [][] the maze
     */
    public boolean findEntrance(int[][] m) {
        for (int x = 0; x < 5; x++) {
            if (m[0][x] == 0) {
                if (exitMaze(m, 0, x))
                    return true;
            }
        }
        
        for (int x = 0; x < 5; x++) {
            if (m[x][0] == 0) {
                if (exitMaze(m, x, 0))
                    return true;
            }
        }
        return false;
    }
    
    /*
     * finds the exit of the maze
     * @param m int [][] the maze
     * @param r int the rows
     * @param c int the columns
     */
    public boolean exitMaze(int[][] m, int r, int c) {
        boolean exit = false;
        if (r >= 0 && r <= 4 && c >= 0 && c <= 4) {
            if (r == 4 && m[r][c] == 0) {
                return true;
            }
            
            m[r][c] = 1;
            
            if (r != 4 && m[r + 1][c] == 0) {
                exit = exit || exitMaze(m, r + 1, c);
            }
            if (r != 0 && m[r - 1][c] == 0) {
                exit = exit || exitMaze(m, r - 1, c);
            }
            if (c != 4 && m[r][c + 1] == 0) {
                exit = exit || exitMaze(m, r, c + 1);
            }
            if (c != 0 && m[r][c - 1] == 0) {
                exit = exit || exitMaze(m, r, c - 1);
            }
        }
        return exit;
    }
    
    /*
     * main method
     * @param args String []
     */
    public static void main(String[] args) {
        ExitMaze m = new ExitMaze();
        int[][] maze =
        {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 0, 1}
        };
        System.out.println(m.findEntrance(maze));
    }
}
