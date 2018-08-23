import java.util.HashSet;

public class ValidSudoku
{
    /**
     * 36. Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the
     * following rules:
     * <p>
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     */
    public static boolean isValidSudoku(char[][] board)
    {
        // Check each column, row and 3x3 only contains 1-9 without dupes
        // HashSet can be used or a boolean array with each index corresponding to the numbers for tracking
        for (int i = 0; i < board.length; i++)
        {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++)
            {
                char c = board[i][j];
                if (c != '.')
                {
                    if (set.contains(c))
                    {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        for (int i = 0; i < board.length; i++)
        {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < board[0].length; j++)
            {
                char c = board[j][i];
                if (c != '.')
                {
                    if (set.contains(c))
                    {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        // Check 3x3 boxes
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                HashSet<Character> set = new HashSet<>();

                int x = i * 3;
                int y = j * 3;
                for (int k = x; k < x + 3; k++)
                {
                    for (int l = y; l < y + 3; l++)
                    {
                        char c = board[k][l];
                        if (c != '.')
                        {
                            if (set.contains(c))
                            {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }
        }

        return true;
    }

}
