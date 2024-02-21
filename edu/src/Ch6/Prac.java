package Ch6;

import java.util.Random;
import java.util.Arrays;
import Ch6.Matrix;

public class Prac {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random rnd = new Random();
		rnd.setSeed(100);
		
		int array[] = new int[24];
		
		for(int i=0; i<array.length; i++) {
			array[i] = rnd.nextInt(100); // random numbers ranging from 1 to 20
		}
		
		int arraySorted[] = array.clone();
		Arrays.sort(arraySorted);
		System.out.println("original array: " + Arrays.toString(array));
		System.out.println("sorted array: " + Arrays.toString(arraySorted));
		
		System.out.println("===results are as follows===");
		Matrix mA = new Matrix(array, 0, 3, 4);
		System.out.print("mA : ");
		mA.print();
		Matrix mB = new Matrix(array, 12, 3, 4);
		System.out.print("mB : ");
		mB.print();
		
//		int[][] test = mA.getArray();
//		System.out.println(test[0][0]);
//
//		//easier way to go
//		int[][] maArray = mA.getArray();
//		int[][] mbArray = mB.getArray();
//		int[][] mC = new int[maArray.length][maArray[0].length];
//		for(int i=0; i<mC.length;i++) {
//			for(int j=0; j<mC[0].length;j++) {
//				mC[i][j] = maArray[i][j] + mbArray[i][j];
//			}
//		}
//		
//		System.out.println(Arrays.deepToString(mC));
		
		System.out.print("mC : ");
		Matrix mC = Matrix.sum(mA,mB);
		mC.print();
	}

}