package middle;

import cn.edu.kust.medium.LongestCommonSubsequence;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTest {
    private LongestCommonSubsequence lcs = new LongestCommonSubsequence();

    @Test void testNomal() {
        Assertions.assertEquals(4, lcs.lcs("ABCBDAB", "BDCABA"));
        Assertions.assertEquals(3, lcs.lcs("abcde", "ace"));
        Assertions.assertEquals(0, lcs.lcs("abc", "def"));
    }

    @Test void  testOneNone() {
        Assertions.assertEquals(0, lcs.lcs("", "abc"));
        Assertions.assertEquals(0, lcs.lcs("abc", ""));
    }
}
