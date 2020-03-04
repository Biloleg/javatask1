package rectanglesTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rectangles.WrongRectangleException;

import static rectangles.ArrayAnalyzer.countRectangles;

public class Tests {

    @Test
    public static void TestBigMatrix() throws WrongRectangleException {
        int[][] arr = {
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };

        Assert.assertEquals(countRectangles(arr), 8, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestCorners() throws WrongRectangleException {
        int[][] arr = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        Assert.assertEquals(countRectangles(arr), 4, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestCenter() throws WrongRectangleException {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Assert.assertEquals(countRectangles(arr), 1, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestNoZeros() throws WrongRectangleException {
        int[][] arr = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        Assert.assertEquals(countRectangles(arr), 1, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestNoRectangles() throws WrongRectangleException {
        int[][] arr = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        Assert.assertEquals(countRectangles(arr), 0, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestEmptyMatrix() throws WrongRectangleException {
        int[][] arr = new int[0][0];

        Assert.assertEquals(countRectangles(arr), 0, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestWrongRectangleLeft() {
        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        try {
            countRectangles(arr);
            Assert.fail("No exception was throw");
        } catch (WrongRectangleException e) {
            Assert.assertEquals(e.getMessage(), "There is no empty space to the left of the square", "Wrong exception message");
        }
    }

    @Test
    public static void TestWrongRectangleRight() {
        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        try {
            countRectangles(arr);
            Assert.fail("No exception was throw");
        } catch (WrongRectangleException e) {
            Assert.assertEquals(e.getMessage(), "There is no empty space to the right of the square", "Wrong exception message");
        }
    }

    @Test
    public static void TestWrongRectangleUnder() {
        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 1, 0, 0}
        };
        try {
            countRectangles(arr);
            Assert.fail("No exception was throw");
        } catch (WrongRectangleException e) {
            Assert.assertEquals(e.getMessage(), "There is no empty space under the square", "Wrong exception message");
        }
    }

    @Test
    public static void TestWrongRectangleZeroInside() {
        int[][] arr = {
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };
        try {
            countRectangles(arr);
            Assert.fail("No exception was throw");
        } catch (WrongRectangleException e) {
            Assert.assertEquals(e.getMessage(), "There is a some zero(s) inside the square", "Wrong exception message");
        }
    }
}
