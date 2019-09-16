package easy;

import cn.edu.kust.easy.ValidParentheses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidParenthesesTest {
    private ValidParentheses vp = new ValidParentheses();

    @Test void testTrue() {
        Assertions.assertEquals(true, vp.isValid("()"));
        Assertions.assertEquals(true, vp.isValid("()[]{}"));
        Assertions.assertEquals(true,vp.isValid("{[]}"));
    }

    @Test void testFalse() {
        Assertions.assertEquals(false, vp.isValid("(]"));
        Assertions.assertEquals(false, vp.isValid("([)]"));
    }
}
