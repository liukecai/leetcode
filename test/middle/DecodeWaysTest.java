package middle;

import cn.edu.kust.medium.DecodeWays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DecodeWaysTest {
    private DecodeWays dw = new DecodeWays();

    @Test
    public void testStr1() {
        assertEquals(2, dw.numDecodings("12"));
    }

    @Test
    public void testStr2() {
        assertEquals(3, dw.numDecodings("226"));
    }

    @Test
    public void testStr3() {
        assertEquals(0, dw.numDecodings("0"));
    }

    @Test
    public void testStr4() {
        assertEquals(1, dw.numDecodings("20"));
    }

    @Test
    public void testStr5() {
        assertEquals(0, dw.numDecodings("012"));
    }

    @Test
    public void testStr6() {
        assertEquals(1, dw.numDecodings("110"));
    }

    @Test
    public void testStr7() {
        assertEquals(0, dw.numDecodings("1100"));
    }

    @Test
    public void testStr8() {
        assertEquals(1, dw.numDecodings("101"));
    }

    @Test
    public void testStr9() {
        assertEquals(5, dw.numDecodings("1212"));
    }

    @Test
    public void testStr10() {
        assertEquals(3, dw.numDecodings("12120"));
    }
}
