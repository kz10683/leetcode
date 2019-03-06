package solutions;

public class MergeSortedArray
{
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
     * one sorted array.
     * <p>
     * Note: You may assume that nums1 has enough space (size that is greater or
     * equal to m + n) to hold additional elements from nums2. The number of
     * elements initialized in nums1 and nums2 are m and n respectively.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Starting from the end of nums1, start setting largest values from nums1 and
        // nums2.
        while (i >= 0 && j >= 0)
        {
            if (nums1[i] > nums2[j])
            {
                nums1[k] = nums1[i];
                i--;
            }
            else
            {
                nums1[k] = nums2[j];
                j--;
            }

            k--;
        }

        // Set leftover values, if any
        while (j >= 0)
        {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}