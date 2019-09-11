package hard;

import cn.edu.kust.hard.EditDistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EditDistanceTest {
    private EditDistance ed = new EditDistance();

    @Test
    public void test1() {
        assertEquals(3, ed.minDistance("horse", "ros"));
    }

    @Test
    public void test2() {
        assertEquals(5, ed.minDistance("intention", "execution"));
    }

    @Test
    public void test3() {
        assertEquals(10, ed.minDistance("zoologicoarchaeologist", "zoogeologist"));
    }
}
