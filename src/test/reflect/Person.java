package test.reflect;

public class Person {

	private String name;
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void sayHello(){

		System.out.println("hello world");
	}

	@Override
	public String toString(){
		return name + " : " + age;
	}

	public Person(String name, Integer age){

		this.age = age;
		this.name = name;
	}

	public Person(){

		age = -1;
		name = "hello";
	}


}
