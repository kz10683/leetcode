import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle
{
    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     */
    public static List<List<Integer>> generate(int numRows)
    {
        // For example, given numRows = 5, Return
        // [1],
        // [1,1],
        // [1,2,1],
        // [1,3,3,1],
        // [1,4,6,4,1]
        // The algorithm is self-explanatory. Just draw out the values at each index.

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0)
        {
            return result;
        }

        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++)
        {
            List<Integer> currentRow = new ArrayList<Integer>();
            for (int j = 0; j <= i; j++)
            {
                // The first and last indices of every row are always 1
                if (j == 0 || j == i)
                {
                    currentRow.add(1);
                }
                else
                {
                    // Otherwise, retrieve the previous row and sum the appropriate values
                    List<Integer> previousRow = result.get(i - 1);
                    currentRow.add(previousRow.get(j) + previousRow.get(j - 1));
                }
            }
            result.add(currentRow);
        }

        return result;
    }

    public static void main(String[] args)
    {
        System.out.println(PascalsTriangle.generate(5));
    }
}
