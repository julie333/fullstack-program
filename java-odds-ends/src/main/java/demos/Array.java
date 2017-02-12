package demos;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {

		int[][] grid = new int[10][10];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {

				grid[i][j] = (i + 1) * (j + 1);
			}
		}
		// System.out.println(Arrays.deepToString(grid));

		print2dArray(grid);

		String[][] grid1 = new String[3][3];

		for (int i = 0; i < grid1.length; i++) {
			for (int j = 0; j < grid1.length; j++) {

				grid1[i][j] = "("+(i + 1) + "," + (j + 1)+")";
			}
		}
		
		print2dArray(grid1);
	}

	private static void print2dArray(Object[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

	private static void print2dArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(Arrays.toString(array[i]));
		}
	}

}
