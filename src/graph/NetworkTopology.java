package graph;

import edge.NetworkConnection;
import vertex.Vertex;

public class NetworkTopology extends ConcreteGraph{
	private String name;
	private final Graph<Vertex, NetworkConnection> graphf = Graph.empty();
	
	public NetworkTopology(String name) {
		this.setName(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Graph<Vertex, NetworkConnection> getGraphf() {
		return graphf;
	}
	
}
