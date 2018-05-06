package vertex;

public class Person extends Vertex{
	private String lable;
	private int age;
	private String gender;
	private double yxl;
	public String getLable() {
		return lable;
	}
	public void setLable(String lable) {
		this.lable = lable;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String isGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Person(String lable) {
		this.lable=lable;
	}
	public double getYxl() {
		return yxl;
	}
	public void setYxl(double yxl) {
		this.yxl = yxl;
	}
}
