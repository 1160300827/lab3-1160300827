package helper;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class dc implements SF{

	@Override
	public double result(Graph<Vertex, Edge> g, Vertex v) {
		return 	(double)g.sources(v).keySet().size()/(g.vertices().size()-1);
	}

}
