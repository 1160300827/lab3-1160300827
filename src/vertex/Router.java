package vertex;

public class Router extends Vertex{
	private String IP;
	public Router(String label) {
		this.name=label;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
}
