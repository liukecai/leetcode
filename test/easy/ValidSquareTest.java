package easy;

import cn.edu.kust.easy.ValidSquare;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidSquareTest {
    private ValidSquare vs = new ValidSquare();

    @Test void test() {
        Assertions.assertEquals(true, vs.isPerfectSquare(0));
        Assertions.assertEquals(true, vs.isPerfectSquare(1));
        Assertions.assertEquals(true, vs.isPerfectSquare(9));
        Assertions.assertEquals(false, vs.isPerfectSquare(10));
        Assertions.assertEquals(false, vs.isPerfectSquare(11));
        Assertions.assertEquals(false, vs.isPerfectSquare(12));
        Assertions.assertEquals(true, vs.isPerfectSquare(16));
        Assertions.assertEquals(false, vs.isPerfectSquare(2147483647));
    }
}
