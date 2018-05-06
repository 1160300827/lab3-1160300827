package graph;

import edge.WordEdge;
import vertex.Word;

public class GraphPoet extends ConcreteGraph{
	private String name;
	private final Graph<Word, WordEdge> graph = Graph.empty();
	public GraphPoet(String name) {
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Graph<Word, WordEdge> getGraph() {
		return graph;
	}
}
