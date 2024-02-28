package Ch12;

class Bag4<T extends Solid,N>{ // T ~ class
	private T thing;
	private N name;
	
	public Bag4() {}
	
	public Bag4(T thing, N name) {
		this.thing = thing;
		this.name = name;
	}

	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public N getName() {
		return name;
	}

	public void setName(N name) {
		this.name = name;
	}
	
	void showType() {
		System.out.println("a type of T is : " + thing.getClass().getName());
		System.out.println("a type of N is : " + name.getClass().getName());
	}
}

class Solid{}
class Book4 extends Solid{

	@Override
	public String toString() {
		return "Newbook";
	}
	
}
class Pencilcase extends Solid{}
class Liquid{}
class Water extends Liquid{}

public class Backpack4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bag4<Book4, String> bag1 = new Bag4<Book4, String>(new Book4(), "science");
		bag1.showType();
		
		Book4 nb = bag1.getThing();
		String name = bag1.getName();
		
		System.out.println(nb + " is about " + name);
		
		
	}

}