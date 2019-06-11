package solutions;

public class UniquePaths
{
    /**
     * 62. A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the
     * bottom-right corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * How many possible unique paths are there?
     */
    public int uniquePaths(int m, int n)
    {
        // Create an array that tracks the number of paths possible at each (i,j) index.
        // For the first row and column, there is only 1 path possible. However, for non-zero indices, the number of
        // unique paths would be the sum of the paths at indices to the left and above it.
        int[][] paths = new int[m][n];

        for (int i = 0; i < paths.length; i++)
        {
            for (int j = 0; j < paths[0].length; j++)
            {
                if (i == 0 || j == 0)
                {
                    paths[i][j] = 1;
                }
                else
                {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }
}
