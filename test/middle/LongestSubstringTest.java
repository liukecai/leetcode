package middle;

import cn.edu.kust.medium.LongestSubstring;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestSubstringTest {
    private LongestSubstring ls = new LongestSubstring();

    @Test void test() {
        Assertions.assertEquals(6, ls.lsb("asdfas", "werasdfaswer"));
    }

}
