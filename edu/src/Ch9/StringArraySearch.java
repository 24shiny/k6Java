package Ch9;

import java.util.Arrays;
//구현 실습 코드
import java.util.Scanner;

public class StringArraySearch {
	static void getData(String[] arr) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<arr.length;i++) {
			arr[i] = sc.next();
		}
	}
	static void showData(String[] arr) {
		for(int i=0; i<arr.length;i++) {
			System.out.println(Arrays.toString(arr));
		}
	}
	/*
	 * 교재 407 Test02: if (s1 == s2)
	 * 교재 409 Test02: if (s1.equals(s2))
	 * compareTo() 사용 
	 */
	static boolean findString(String[] arr, String st) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].compareTo(st)==0) {
				return true;
			}
		}
		System.out.println(st + "배열에 없다");
	}
	public static void main(String[] args) {
		String[]arr= new String[5];
		//화면에서 입력
		getData(arr);
		showData(arr);
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
//		boolean result = 
		findString(arr, st);

	}
}