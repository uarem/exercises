package main;

/**
 * Created by uarem on 4/17/2015.
 */
public class FindLands {

    private void visitIslands(int m, int n, int width, int length, char[][] inputMap, int[][] footstep) {
        footstep[m][n] = 1;
        if (m-1 >= 0 && inputMap[m-1][n] == '1' && footstep[m-1][n] != 1)
            visitIslands(m - 1, n, width, length, inputMap, footstep);
        if (m+1 < length && inputMap[m+1][n] == '1' && footstep[m+1][n] != 1)
            visitIslands(m + 1, n, width, length, inputMap, footstep);
        if (n-1 >= 0 && inputMap[m][n-1] == '1' && footstep[m][n-1] != 1)
            visitIslands(m, n - 1, width, length, inputMap, footstep);
        if (n+1 < width && inputMap[m][n+1] == '1' && footstep[m][n+1] != 1)
            visitIslands(m, n + 1, width, length, inputMap, footstep);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length <= 0)
            return count;

        int width = grid[0].length;
        int length = grid.length;
        int[][] footstep = new int[length][width];

        for (int j=0; j<length; j++) {
            for (int i=0; i<width; i++) {
                if (grid[j][i] == '1' && (count == 0 || footstep[j][i] != 1)) {
                    count++;
                    visitIslands(j, i, width, length, grid, footstep);
                }

            }
        }

        return count;
    }


}
