package Assignment0215;
/*
 * 클래스 메소드 구현 실습 목적
 */
import java.util.Random;
import java.util.Arrays;

class Matrix {
	int rows;
	int cols;
	int totalLength = rows*cols;
	int[] data;
	int[][] reshaped;
	
	public Matrix(int rows, int cols) {
		this.rows = rows; this.cols = cols;
		this.totalLength = rows*cols;
		data = new int[totalLength];
	}
	void getData() {
		// 난수로 입력
		Random rnd = new Random();
		for(int i=0; i<this.totalLength;i++) {
			this.data[i] = rnd.nextInt(10);
		}
	}
	
	//method for reshaping matrices, overloading
	void reshapeMatrix() {
		this.reshaped = new int[this.rows][this.cols];
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<this.cols; j++) {
				this.reshaped[i][j] = this.data[this.cols*i+j];
			}
		}
	}
	
	void reshapeMatrix(Matrix m) {
		m.reshaped = new int[m.rows][m.cols];
		for(int i=0; i<m.rows; i++) {
			for(int j=0; j<m.cols; j++) {
				m.reshaped[i][j] = m.data[m.cols*i+j];
			}
		}
	}
	
	//add matrix C to the instance matrix B
	Matrix addMatrix(Matrix c) {
		Matrix addResult = new Matrix(this.rows, this.cols);
		reshapeMatrix();
		reshapeMatrix(c);
		
		addResult.reshaped = new int[addResult.rows][addResult.cols];
		for(int i=0; i<this.rows;i++)
			for(int j=0; j<this.cols; j++){
			addResult.reshaped[i][j] = this.reshaped[i][j] + c.reshaped[i][j];
		}
	return addResult;
	}
	
	//multiply the instance matrix B by E
	Matrix multiplyMatrix(Matrix e) {
		Matrix multiplyResult = new Matrix(this.rows, e.cols);
		
		reshapeMatrix();	
		reshapeMatrix(e);
		
		multiplyResult.reshaped = new int[multiplyResult.rows][multiplyResult.cols];
		for(int i=0; i<this.rows; i++) {
			for(int j=0; j<e.cols; j++) {
				for(int k=0; k<this.cols; k++) {
					multiplyResult.reshaped[i][j] += this.reshaped[i][k] * e.reshaped[k][j];
				}
			}
		}
		return multiplyResult;	
	}
	
	// transpose of the instance matrix
	Matrix transposeMatrix() {
		Matrix transposeResult = new Matrix(this.cols, this.rows);
		//reshape B
		reshapeMatrix();
		
		transposeResult.reshaped = new int[this.cols][this.rows];
		for(int i=0; i<this.cols; i++) {
			for(int j=0; j<this.rows; j++) {
				transposeResult.reshaped[i][j] = this.reshaped[j][i];
			}
		}
		return transposeResult;
	}
	
	//print matrices
	void showMatrix() {
		
		for(int[] i:this.reshaped) {
			System.out.println(Arrays.toString(i));
		}
	}
	
	//print arrays
	void print() {
		System.out.println(Arrays.toString(this.data));
	}
	
}
public class MatrixClass {

	public static void main(String[] args) {
		/*
		 * 난수 생성으로 초기화
		 * A[3][4] = B[3][4] + C[3][4]; D[3][5] = B[3][4] * E[4][5];
		 * F[4][3] = B[3][4]의 전치 행렬
		 */
		Matrix B = new Matrix(3,4);
		Matrix C = new Matrix(3,4);
		Matrix A, D, F;
		Matrix E = new Matrix(4,5);

		System.out.println("행렬 더하기: A[3][4] = B[3][4] + C[3][4]");
		B.getData();C.getData();E.getData();
		A = B.addMatrix(C);
		System.out.println("B: "); B.showMatrix();		
		System.out.println("C: "); C.showMatrix();
		System.out.println("A:"); A.showMatrix();
		
	
		System.out.println("\n");
		System.out.println("행렬 곱하기: D[3][5] = B[3][4] * E[4][5]");
		D = B.multiplyMatrix(E);
		System.out.println("B:"); B.showMatrix();
		System.out.println("E:"); E.showMatrix();
		System.out.println("D:"); D.showMatrix();
		
		System.out.println("\n");
		System.out.println("행렬 전치: F[4][3] = B[3][4]의 전치 행렬");
		F = B.transposeMatrix();
		System.out.println("B:"); B.showMatrix();
		System.out.println("F:"); F.showMatrix();
		
		}

}