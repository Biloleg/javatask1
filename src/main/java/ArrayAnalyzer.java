import java.util.Arrays;

public class ArrayAnalyzer {
    public static int countRectangles(int[][] array) {
        int[][] testArray = cloneArray(array);
        int count = 0;
        for (int i = 0; i < testArray.length; i++) {
            for (int j = 0; j < testArray[i].length; j++) {
                if (testArray[i][j] == 1) {
                    eraseRectangle(testArray, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void eraseRectangle(int[][] arrayToReplace, int y, int x) {
        int x2 = x;
        for (int i = x; i < arrayToReplace[y].length && arrayToReplace[y][i] != 0; i++) {
            x2 = i;
        }
        for (int j = y; j < arrayToReplace.length && arrayToReplace[j][x] != 0; j++) {
            Arrays.fill(arrayToReplace[j], x, x2 + 1, 0);
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
