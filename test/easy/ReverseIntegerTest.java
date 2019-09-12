package easy;

import cn.edu.kust.easy.ReverseInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {
    ReverseInteger ri = new ReverseInteger();

    @Test void test() {
        Assertions.assertEquals(23, ri.reverse(32));
        Assertions.assertEquals(23, ri.reverse2(32));

        Assertions.assertEquals(1, ri.reverse(10));
        Assertions.assertEquals(1, ri.reverse2(10));

        Assertions.assertEquals(0, ri.reverse(00));
        Assertions.assertEquals(0, ri.reverse2(00));
    }
}
