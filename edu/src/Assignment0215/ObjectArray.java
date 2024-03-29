package Assignment0215;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */

//level1
abstract class InterfaceStudents {
	public abstract void showObject();
}
//level2
class Student extends InterfaceStudents {
 static int countStudents=0;//객체수
 int sid;//학번
 String sname; //학생 이름
 String city; //주소 도시
 {
	 countStudents++;
 }
 public String toString() {
	 return "sid="+sid + ", sname=" + sname + ", city=" + city;
 }
 public void showObject() {
	 System.out.println("["+sid +", " + sname + ", " + city+"]");
 }
 static void showNumberObjects() {//생성된 객체수를 출력한다.
	 System.out.println(" 생성객체수=" + countStudents);
 }
}
//level3
class WorkStudent extends Student {
	String eno; //?
	String company;
	 public String toString() {
		 return "eno="+eno + ", company=" + company;
	 }
	 public void showObject() {
		 //Student 출력 코드 추가
		 System.out.println("["+super.sid +", " + super.sname + ", " + super.city +", "+eno +", " + company + "]");
	 }
}

//level4
class CodingWorkStudent extends WorkStudent {
	String language;
	 public String toString() {
		 return "language="+language;
	 }
	 public void showObject() {
		 //WorkStudent 출력 코드 추가
		 System.out.println("["+ super.sid +", " + super.sname + ", " + super.city +", "+eno +", " + company +
				 super.eno + ", " + super.company + ", " + language+"]");
	 }
}

 //main
 // 생성자 구현한다.
public class ObjectArray {
	
	 static void showObjects(InterfaceStudents is) {
		 is.showObject();
	 }
	 
	 public static void main(String[] args) {
	 Student[] arry = new Student[5];
	 Student.showNumberObjects();
	 
	 arry[0] = new Student();
	 arry[1] = new Student();
	 arry[2] = new WorkStudent();
	 arry[3] = new CodingWorkStudent();
	 arry[4] = new WorkStudent();
	 
	 //all students
	 arry[0].sid = 20240; arry[0].sname="Alice"; arry[0].city="Los Angeles";
	 arry[1].sid = 20241; arry[1].sname="Bob"; arry[1].city="San Francisco";
	 arry[2].sid = 20242; arry[2].sname="Catherin"; arry[2].city="San Diego";
	 arry[3].sid = 20243; arry[3].sname="Daniel"; arry[3].city="Sacramento";
	 arry[4].sid = 20244; arry[4].sname="Esther"; arry[4].city="San Jose";
	  
	 //down casting for the workstudents
	 WorkStudent ws1 = (WorkStudent) arry[2];
	 WorkStudent ws2 = (WorkStudent) arry[4];
	 ws1.eno = "ENO1"; ws1.company="Google";
	 ws2.eno = "ENO3"; ws2.company="Amazon";
	 
	 //downcasting for the codingworkstudent
	 CodingWorkStudent cws1 = (CodingWorkStudent) arry[3];
	 cws1.eno = "ENO2"; cws1.company="Apple";
	 cws1.language = "English";
	 
	 Student.showNumberObjects();
	 System.out.println();
	 System.out.println("=== results of toString ===");
	 for (Student s : arry) {
		 System.out.println(s.toString());
	 }
	 
	 System.out.println();
	 System.out.println("=== results of showObjects ===");
	 
	 for (Student sx : arry) {
		 showObjects(sx);
	 }
 }

}
