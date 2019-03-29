package solutions;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix
{
    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * <p>
     * Example 2:
     * <p>
     * Input:
     * [
     * [1, 2, 3, 4],
     * [5, 6, 7, 8],
     * [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public static List<Integer> spiralOrder(int[][] matrix)
    {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
        {
            return list;
        }

        // The idea is to create four "walls" that act as boundaries. Increase/decrease as we traverse through each
        // row and column. We loop until one of these wall is crossed.

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true)
        {
            // Go right
            for (int i = left; i <= right; i++)
            {
                list.add(matrix[top][i]);
            }
            top++;

            if (isCrossed(top, bottom, left, right))
            {
                break;
            }

            // Go down
            for (int i = top; i <= bottom; i++)
            {
                list.add(matrix[i][right]);
            }
            right--;

            if (isCrossed(top, bottom, left, right))
            {
                break;
            }

            // Go left
            for (int i = right; i >= left; i--)
            {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            if (isCrossed(top, bottom, left, right))
            {
                break;
            }

            // Go up
            for (int i = bottom; i >= top; i--)
            {
                list.add(matrix[i][left]);
            }
            left++;

            if (isCrossed(top, bottom, left, right))
            {
                break;
            }
        }

        return list;
    }

    private static boolean isCrossed(int top, int bottom, int left, int right)
    {
        if (top > bottom || left > right)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        System.out.println(SpiralMatrix.spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        System.out.println(SpiralMatrix.spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
    }
}
