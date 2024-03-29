package Ch8;

import static Ch8.Mandarin.*;
import java.util.Scanner;

public class manMain {
	static Scanner stdIn = new Scanner(System.in);
	Mandarin m[] = Mandarin.values();//Mandarin의 생성자를 호출하고 각 값을 생성자 함수에 전달한다.
	//values()는 static 함수로 열거된 모든 원소를 배열로 리턴
	static Mandarin selectMenu() {
		int key;
		do {
		for (Mandarin m : Mandarin.values()) {//Mandarin m[] = Mandarin.values();와 의미가 같다 
			System.out.print(m.ordinal()+ ".");
			System.out.println(" " + m + "(" + m.getPrice()+ ")");
		}
		System.out.println("선택: ");
		key = stdIn.nextInt();
		} while(key < Mandarin.금귤.ordinal() || key > Mandarin.황금향.ordinal());
		
		return Mandarin.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin m;//생성자를 호출하지 않는다
		//Mandarin m2 = new Mandarin(100);//생성자를 호출할 수 없다 - 주의점 
		//*
		Mandarin ma = Mandarin.한라봉;//enum 클래스 생성자가 호출된다 
		System.out.println("enum 객체 생성전");
		System.out.println("황금향과 비교: "+ ma.compareTo(Mandarin.레드향));
		Mandarin m2	= Mandarin.금귤;
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);

		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for (Mandarin m3 : list)
			System.out.println(m3 + ":" + m3.getPrice());
			
			//*/
		Mandarin mSelected = selectMenu();
		System.out.println(mSelected + ":selectedMenu:" + mSelected.getPrice());
	}

}
