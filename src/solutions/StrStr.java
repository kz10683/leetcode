package solutions;

public class StrStr
{
    /**
     * Implement strStr().
     * <p>
     * Returns the index of the first occurrence of needle in haystack, or -1 if
     * needle is not part of haystack.
     */
    public static int strStr(String haystack, String needle)
    {
        if (needle.isEmpty())
        {
            return 0;
        }

        int index = -1;

        for (int i = 0; i < haystack.length(); i++)
        {
            // start searching remainder of needle
            if (haystack.charAt(i) == needle.charAt(0))
            {
                for (int j = 0; j < needle.length(); j++)
                {
                    // length of needle exceeds rest of haystack
                    if (i + j > haystack.length() - 1)
                    {
                        return -1;
                    }
                    // stop iteration if character mismatch
                    else if (haystack.charAt(i + j) != needle.charAt(j))
                    {
                        break;
                    }
                    // reached end of needle, which means every character matched
                    else if (j == needle.length() - 1)
                    {
                        return i;
                    }
                }

            }
        }

        return index;
    }

    public static void main(String[] args)
    {
        System.out.println(StrStr.strStr("haystackneedlehaystack", "needle"));
        System.out.println(StrStr.strStr("haystack", "needle"));
        System.out.println(StrStr.strStr("stack", "needle"));
        System.out.println(StrStr.strStr("mississippi", "issip"));
    }
}
