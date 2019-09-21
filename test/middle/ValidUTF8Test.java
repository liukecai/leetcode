package middle;

import cn.edu.kust.medium.ValidUTF8;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidUTF8Test {
    private ValidUTF8 validUTF8 = new ValidUTF8();

    @Test void testTrue() {
        Assertions.assertEquals(true, validUTF8.validUtf8(new int[]{197, 130, 1}));
        Assertions.assertEquals(true, validUTF8.validUtf8(new int[]{230,136,145}));
        Assertions.assertEquals(true, validUTF8.validUtf8(new int[]{240,162,138,147}));
    }

    @Test void testFalse() {
        Assertions.assertEquals(false, validUTF8.validUtf8(new int[]{250,145,145,145,145}));
    }
}
