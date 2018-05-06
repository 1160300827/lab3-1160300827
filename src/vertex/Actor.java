package vertex;

public class Actor extends Vertex{
	private String lable;
	private int age;
	private String gender;
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
	
	public Actor(String lable) {
		this.lable=lable;
	}
}
