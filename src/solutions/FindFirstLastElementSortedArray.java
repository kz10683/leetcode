package solutions;

import java.util.Arrays;

public class FindFirstLastElementSortedArray
{
    /**
     * 34. Given an array of integers nums sorted in ascending order, find the starting and ending position of a given
     * target value. Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public static int[] searchRange(int[] nums, int target)
    {
        int[] result = new int[] { -1, -1 };
        if (nums == null || nums.length == 0)
        {
            return result;
        }

        // Modified binary search for the left-most index and the right-most index for the given target
        // Similar to FirstBadVersion and RotateArray
        int startIndex = searchStartingIndex(nums, target);
        if (startIndex == -1)
        {
            return result;
        }

        int endIndex = searchEndingIndex(nums, target);
        if (endIndex == -1)
        {
            return result;
        }

        result[0] = startIndex;
        result[1] = endIndex;
        return result;
    }

    private static int searchStartingIndex(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;

        // We exit when left and right are next to each other
        while (left + 1 < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
            {
                right = mid;
            }
            else if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        // Check left first! e.g. cases like [2,2]
        if (nums[left] == target)
        {
            return left;
        }
        else if (nums[right] == target)
        {
            return right;
        }

        return -1;
    }

    private static int searchEndingIndex(int[] nums, int target)
    {
        int left = 0;
        int right = nums.length - 1;

        // We exit when left and right are next to each other
        while (left + 1 < right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
            {
                left = mid;
            }
            else if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }

        // Check left first! e.g. cases like [2,2]
        if (nums[right] == target)
        {
            return right;
        }
        else if (nums[left] == target)
        {
            return left;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(
                Arrays.toString(FindFirstLastElementSortedArray.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));

        System.out.println(
                Arrays.toString(FindFirstLastElementSortedArray.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
    }
}
