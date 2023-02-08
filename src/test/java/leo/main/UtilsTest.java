package leo.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void neighborsNumber_test_1() {
        var cells = new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, false, false}};

        Assertions.assertEquals(1, Utils.neighborsNumber(cells, 1, 1));
    }

    @Test
    public void neighborsNumber_test_4() {
        var cells = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true}};

        Assertions.assertEquals(4, Utils.neighborsNumber(cells, 1, 1));
    }

    @Test
    public void neighborsNumber_test1_1() {
        var cells = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true}};

        Assertions.assertEquals(1, Utils.neighborsNumber(cells, 0, 0));
    }
}
