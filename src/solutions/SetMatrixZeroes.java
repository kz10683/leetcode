package solutions;

import java.util.HashSet;

public class SetMatrixZeroes
{
    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
     * Do it in place.
     */
    public void setZeroes(int[][] matrix)
    {
        HashSet<Integer> rows = new HashSet<Integer>();
        HashSet<Integer> columns = new HashSet<Integer>();

        // Track all rows and columns that need to be set to 0
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        // Set every row and column to 0 that has been marked
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                if (rows.contains(i) || columns.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }

    }

}
