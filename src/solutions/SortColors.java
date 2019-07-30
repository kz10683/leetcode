package solutions;

public class SortColors
{
    /**
     * 75. Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same
     * color are adjacent, with the colors in the order red, white and blue.
     * <p>
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     * <p>
     * Note: You are not suppose to use the library's sort function for this problem.
     * <p>
     * Example:
     * <p>
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     */
    public void sortColors(int[] nums)
    {
        // Two-pass solution. Keep counts of all occurrences of 0, 1, and 2. Then, simply set the array in order, based
        // on the calculated occurrences of each.
        int[] counts = new int[3];
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                counts[0]++;
            }
            else if (nums[i] == 1)
            {
                counts[1]++;
            }
            else if (nums[i] == 2)
            {
                counts[2]++;
            }
        }

        for (int i = 0; i < counts[0]; i++)
        {
            nums[i] = 0;
        }
        for (int i = 0; i < counts[1]; i++)
        {
            nums[counts[0] + i] = 1;
        }
        for (int i = 0; i < counts[2]; i++)
        {
            nums[counts[0] + counts[1] + i] = 2;
        }
    }

    // This is the "Dutch national flag problem". Based on a pivot value (1, in this case), we swap the elements in the
    // array such that all elements less than the pivot value appear before it and all elements greater than the pivot
    // appear after it. This is accomplished using two placeholder indices, which track the "lower" and "upper" bounds
    // of the array that will be swapped with a current index that traverses the array.
    public void sortColorsPivot(int[] nums)
    {
        int lower = 0;
        int upper = nums.length - 1;
        int current = 0;

        int pivotValue = 1;

        while (current <= upper)
        {
            if (nums[current] < pivotValue)
            {
                this.swap(nums, current, lower);
                lower++;
                current++;
            }
            else if (nums[current] > pivotValue)
            {
                this.swap(nums, current, upper);
                upper--;
            }
            else
            {
                current++;
            }
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
