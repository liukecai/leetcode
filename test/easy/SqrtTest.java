package easy;

import cn.edu.kust.easy.Sqrt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SqrtTest {
    private Sqrt sqrt = new Sqrt();

    @Test void test0() {
        assertEquals(0, sqrt.mySqrt(0));
        assertEquals(0, sqrt.mySqrt1(0));
        assertEquals(0, sqrt.mySqrt2(0));
    }

    @Test void test1() {
        assertEquals(1, sqrt.mySqrt(1));
        assertEquals(1, sqrt.mySqrt1(1));
        assertEquals(1, sqrt.mySqrt2(1));
    }

    @Test void test3() {
        assertEquals(3, sqrt.mySqrt(9));
        assertEquals(3, sqrt.mySqrt1(9));
        assertEquals(3, sqrt.mySqrt2(9));

        assertEquals(3, sqrt.mySqrt(10));
        assertEquals(3, sqrt.mySqrt1(10));
        assertEquals(3, sqrt.mySqrt2(10));

        assertEquals(3, sqrt.mySqrt(11));
        assertEquals(3, sqrt.mySqrt1(11));
        assertEquals(3, sqrt.mySqrt2(11));
    }

    @Test void test4() {
        assertEquals(4, sqrt.mySqrt(16));
        assertEquals(4, sqrt.mySqrt1(16));
        assertEquals(4, sqrt.mySqrt2(16));
    }

    @Test void testLarge() {
        assertEquals(46340, sqrt.mySqrt(2147483647));
        assertEquals(46340, sqrt.mySqrt1(2147483647));
        assertEquals(46340, sqrt.mySqrt2(2147483647));
    }
}
