package factory;

import graph.GraphPoet;
import helper.ParseCommandHelper;

public class GraphPoetFactory {
	public static GraphPoet createGraph(String filepath) {
		ParseCommandHelper p = new ParseCommandHelper();
		GraphPoet g = new GraphPoet(p.getGraohName(filepath));
		for(int i=0;i<p.getVertex(filepath).size();i++) {
			g.addVertex(p.getVertex(filepath).get(i));
		}
		for(int i=0;i<p.getEdge(filepath).size();i++) {
			g.addEdge(p.getEdge(filepath).get(i));
		}
		return g;		
	}
}
