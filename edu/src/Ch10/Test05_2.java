package Ch10;

//public class nagativeNumException() extends Exception{
//	public nagativeNumException() {
//	super("negative numbers are not allowed");
//}
//}
public class Test05_2 {
	
	int battery = 0;
	
	public void charge(int time) throws negativeNumException {
		if(time<0) {
			time=0;
			throw new negativeNumException();
		}
		battery += time;
		System.out.println("current battery status : "+ battery);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test05_2 test = new Test05_2();
		try {
		test.charge(30);
		test.charge(50);
		test.charge(-10);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}