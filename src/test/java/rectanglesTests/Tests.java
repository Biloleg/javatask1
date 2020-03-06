package rectanglesTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import rectangles.WrongMatrixException;
import rectangles.WrongRectangleException;

import static rectangles.ArrayAnalyzer.countRectangles;

public class Tests {

    @BeforeMethod
    public void before() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    @Test
    public static void TestBigMatrix() throws WrongRectangleException, WrongMatrixException {
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
    public static void TestCorners() throws WrongRectangleException, WrongMatrixException {
        int[][] arr = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        Assert.assertEquals(countRectangles(arr), 4, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestCenter() throws WrongRectangleException, WrongMatrixException {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Assert.assertEquals(countRectangles(arr), 1, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestNoZeros() throws WrongRectangleException, WrongMatrixException {
        int[][] arr = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

        Assert.assertEquals(countRectangles(arr), 1, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestNoRectangles() throws WrongRectangleException, WrongMatrixException {
        int[][] arr = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        Assert.assertEquals(countRectangles(arr), 0, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestOtherNumbers() throws WrongRectangleException {
        int[][] arr = {
                {33, 2, 0},
                {4, 11, 9},
                {0, 7, 67}
        };
        try {
            countRectangles(arr);
            Assert.fail("No exception was throw");
        } catch (WrongMatrixException e) {
            Assert.assertEquals(e.getMessage(), "Matrix should contains only 0 or 1", "Wrong exception message");
        }
    }

    @Test
    public static void TestEmptyMatrix() throws WrongRectangleException, WrongMatrixException {
        int[][] arr = new int[0][0];

        Assert.assertEquals(countRectangles(arr), 0, "Unexpected number of rectangles in the matrix");
    }

    @Test
    public static void TestWrongRectangleLeft() throws WrongMatrixException {
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
    public static void TestWrongRectangleRight() throws WrongMatrixException {
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
    public static void TestWrongRectangleUnder() throws WrongMatrixException {
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
    public static void TestWrongRectangleZeroInside() throws WrongMatrixException {
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
