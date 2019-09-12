package easy;

import cn.edu.kust.easy.TwoSum;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class TwoSumTest {
    private TwoSum twoSum = new TwoSum();

    @Test void test() {
        assertArrayEquals(new int[]{0, 2}, twoSum.twoSum(new int[]{2,4,6}, 8));
        assertArrayEquals(new int[]{1, 3}, twoSum.twoSum(new int[]{23, 45, 76, 93}, 138));
        assertArrayEquals(new int[]{3, 6}, twoSum.twoSum(new int[]{10, 40, 30, 28, 47, 18, 4}, 32));
        assertArrayEquals(new int[]{0, 4}, twoSum.twoSum(new int[]{12, 45, 34, 67, 23}, 35));
        assertArrayEquals(new int[]{0, 3}, twoSum.twoSum(new int[]{22, 54, 67, 11}, 33));
    }
}
