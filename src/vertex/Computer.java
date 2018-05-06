package vertex;

public class Computer extends Vertex{
	private String IP;
	public Computer(String label) {
		this.name=label;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
}
