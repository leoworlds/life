package leo.main;

import leo.util.NeighborUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NeighborUtilsTest {

    @Test
    void neighborsNumber_test_1() {
        var cells = new boolean[][]{
                {true, false, false},
                {false, true, false},
                {false, false, false}};

        Assertions.assertEquals(1, NeighborUtils.neighborsNumber(cells, 1, 1));
    }

    @Test
    void neighborsNumber_test_4() {
        var cells = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true}};

        Assertions.assertEquals(4, NeighborUtils.neighborsNumber(cells, 1, 1));
    }

    @Test
    void neighborsNumber_test1_1() {
        var cells = new boolean[][]{
                {true, false, true},
                {false, true, false},
                {true, false, true}};

        Assertions.assertEquals(1, NeighborUtils.neighborsNumber(cells, 0, 0));
    }
}
