package middle;

import cn.edu.kust.medium.Atoi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AtoiTest {
    private Atoi atoi = new Atoi();

    @Test
    public void testNoDigit() {
        assertEquals(0, atoi.myAtoi("words and"));
        assertEquals(0, atoi.myAtoi2("words and"));
    }

    @Test
    public void testDigitAndChar() {
        assertEquals(0, atoi.myAtoi("words 987 and"));
        assertEquals(0, atoi.myAtoi2("words 987 and"));

        assertEquals(0, atoi.myAtoi("words and 987"));
        assertEquals(0, atoi.myAtoi2("words and 987"));

        assertEquals(0, atoi.myAtoi("  -0k4"));
        assertEquals(0, atoi.myAtoi2("  -0k4"));
    }

    @Test
    public void testSymbol() {
        assertEquals(0, atoi.myAtoi("+"));
        assertEquals(0, atoi.myAtoi("-"));

        assertEquals(0, atoi.myAtoi2("+"));
        assertEquals(0, atoi.myAtoi2("-"));
    }

    @Test
    public void testNegOverflow() {
        assertEquals(Integer.MIN_VALUE, atoi.myAtoi("-91283472332"));
        assertEquals(Integer.MIN_VALUE, atoi.myAtoi2("-91283472332"));
    }

    @Test
    public void testPosOverflow() {
        assertEquals(Integer.MAX_VALUE, atoi.myAtoi("20000000000000000000"));
        assertEquals(Integer.MAX_VALUE, atoi.myAtoi2("20000000000000000000"));

        assertEquals(Integer.MAX_VALUE, atoi.myAtoi("    +11191657170"));
        assertEquals(Integer.MAX_VALUE, atoi.myAtoi2("    +11191657170"));
    }

    @Test
    public void testNormal() {
        assertEquals(-42, atoi.myAtoi(" -42"));
        assertEquals(-42, atoi.myAtoi2(" -42"));

        assertEquals(-4, atoi.myAtoi(" -04f"));
        assertEquals(-4, atoi.myAtoi2(" -04f"));
    }
}
