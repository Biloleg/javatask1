package rectangles;

import java.util.Arrays;

public class ArrayAnalyzer {
    public static int countRectangles(int[][] array) throws WrongRectangleException {
        int[][] testArray = cloneArray(array);
        int count = 0;
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                if (testArray[i][j] == 1) {
                    eraseRectangle(testArray, j, i);
                    count++;
                }
            }
        }
        return count;
    }

    private static void eraseRectangle(int[][] arrayToErase, int x, int y) throws WrongRectangleException {
        int x2 = x;
        for (int i = x; i < arrayToErase[y].length && arrayToErase[y][i] != 0; i++) {
            x2 = i;
        }
        for (int j = y; j < arrayToErase.length && arrayToErase[j][x] != 0; j++) {
            if (x > 0 && arrayToErase[j][x - 1] != 0)
                throw new WrongRectangleException("There is no empty space to the left of the square");
            if (x2 + 1 < arrayToErase[j].length && arrayToErase[j][x2 + 1] != 0)
                throw new WrongRectangleException("There is no empty space to the right of the square");
            if (j + 1 < arrayToErase.length && arrayToErase[j + 1][x] == 0 && Arrays.stream(Arrays.copyOfRange(arrayToErase[j + 1], x, x2 + 1)).anyMatch(e -> e == 1))
                throw new WrongRectangleException("There is no empty space under the square");
            if (Arrays.stream(Arrays.copyOfRange(arrayToErase[j], x, x2 + 1)).anyMatch(e -> e == 0))
                throw new WrongRectangleException("There is a some zero(s) inside the square");

            Arrays.fill(arrayToErase[j], x, x2 + 1, 0);
        }
    }

    private static int[][] cloneArray(int[][] arr) {
        int[][] forReturn = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            forReturn[i] = arr[i].clone();
        }
        return forReturn;
    }
}
