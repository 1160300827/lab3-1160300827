package factory;

import graph.MovieGraph;
import helper.ParseCommandHelper;

public class MovieGraphFactory {
	public static MovieGraph createGraph(String filepath) {
		ParseCommandHelper p = new ParseCommandHelper();
		MovieGraph g = new MovieGraph(p.getGraohName(filepath));
		for(int i=0;i<p.getVertex(filepath).size();i++) {
			g.addVertex(p.getVertex(filepath).get(i));
		}
		for(int i=0;i<p.getEdge(filepath).size();i++) {
			g.addEdge(p.getEdge(filepath).get(i));
		}
		return g;
	}
}
