package Ch6;

import java.util.Arrays;

public class Matrix {
	
	private int[][] newArray;
	private int[][] prodArray;
	private int row;
	private int col;
	
	public Matrix(int[][] array) {
		newArray = array;
	}
	
	public Matrix(int array[], int start, int row, int col) {
		this.newArray = new int[row][col];
		this.row = row;
		this.col = col;
		Arrays.sort(array);
		for(int i=0; i<row;i++) {
			for(int j=0; j<col;j++) {
				this.newArray[i][j] = array[start+4*i+j];
			}
		}
	}
	
	public void print() {
		System.out.println(Arrays.deepToString(newArray));
	}
	
	public static Matrix sum(Matrix mA, Matrix mB){ // static!
		int row = mA.newArray.length;
		int col = mB.newArray[0].length;
		int[][] sumArray = new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				sumArray[i][j] = mA.newArray[i][j] + mB.newArray[i][j];
			}
		}
		return new Matrix(sumArray);
	}
	
}