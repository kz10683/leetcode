package solutions;

public class ContainerWater
{
    /**
     * 11. Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n
     * vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which
     * together with x-axis forms a container, such that the container contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     */
    public static int maxArea(int[] height)
    {
        int maxArea = 0;

        // Loop through every combination and find the max area at each i,j
        for (int i = 0; i < height.length; i++)
        {
            for (int j = 1; j < height.length; j++)
            {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static int maxArea2(int[] height)
    {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right)
        {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);

            if (height[left] > height[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        System.out.println(ContainerWater.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(ContainerWater.maxArea2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }
}
