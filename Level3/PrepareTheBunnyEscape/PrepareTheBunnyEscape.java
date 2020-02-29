import java.util.LinkedList;
import java.util.Queue;

class Move {
    int row;
    int col;
    int count;
    int remBombs;

    public Move(int row, int col, int count, int remBombs){
        this.row = row;
        this.col = col;
        this.count = count;
        this.remBombs = remBombs;
    }
}
public class PrepareTheBunnyEscape {

    public static void main(String[] args) {

        int[][] map1 = {
                {0, 1},
                {0, 0}
        };
        System.out.println(solution(map1));

        int[][] map2 = {
                {0, 1, 1, 0},
                {0, 0, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 0}
        };
        System.out.println(solution(map2));

        int[][] map4 = {
                {0, 1, 1, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 1, 0},
        };
        System.out.println(solution(map4));

        int[][] map3 = {
                {0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
        };
        System.out.println(solution(map3));
    }

    /**
     * Calculates the length of shortest path from prison door to escape pod for a given map
     * @param   map     Map of space station containing walls and empty spaces
     * @return  Returns the length of shortest path from prison door to escape pod
     */
    public static int solution(int[][] map) {
        int height = map.length;
        int width = map[0].length;
        // Number of Bombs we have here is 1
        int numBombs = 1;

        // We maintain the visited 3d array for row, column and number of bombs remaining
        // while exploring that node.
        // This helps us explore the same node further if the number
        // of bombs we have after arriving at this node is different than what we had encountered before
        boolean[][][] visited = new boolean[height][width][numBombs + 1];

        Queue<Move> q = new LinkedList<>();
        q.add(new Move(0, 0, 0, numBombs));
        int minSteps = Integer.MAX_VALUE;

        // Performing BFS starting from prison door (top left) of the map
        while (!q.isEmpty()){

            Move cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int count = cur.count;
            int remBombs = cur.remBombs;

            // If we reach the escape pod (bottom right),
            // take the minimum of current path length and shortest path found so far
            if(row == height - 1 && col == width - 1)
                minSteps = Math.min(minSteps, count + 1);

            if(!visited[row][col][remBombs]){
                visited[row][col][remBombs] = true;

                // If current node is a wall, blow the wall if we have bombs available, and reduce the bomb count
                // else stop exploring current path
                if(map[row][col] == 1){
                    if(remBombs == 0)
                        continue;
                    remBombs--;
                }

                if(row < height - 1){
                    // Only add nodes which we haven't already explored
                    if(!visited[row + 1][col][remBombs])
                        q.add(new Move(row + 1, col, count + 1, remBombs));
                }
                if(row > 0){
                    if(!visited[row - 1][col][remBombs])
                        q.add(new Move(row - 1, col, count + 1, remBombs));
                }
                if(col < width - 1){
                    if(!visited[row][col + 1][remBombs])
                        q.add(new Move(row, col + 1, count + 1, remBombs));
                }
                if(col > 0){
                    if(!visited[row][col - 1][remBombs])
                        q.add(new Move(row, col - 1, count + 1, remBombs));
                }
            }
        }

        return minSteps;
    }
}
