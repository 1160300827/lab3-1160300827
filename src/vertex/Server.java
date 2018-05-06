package vertex;

public class Server extends Vertex{
	private String IP;
	public Server(String label) {
		this.name=label;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
}
