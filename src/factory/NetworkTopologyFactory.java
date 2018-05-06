package factory;

import graph.NetworkTopology;
import helper.ParseCommandHelper;

public class NetworkTopologyFactory {
	public static NetworkTopology createGraph(String filepath) {
		ParseCommandHelper p = new ParseCommandHelper();
		NetworkTopology g = new NetworkTopology(p.getGraohName(filepath));
		for(int i=0;i<p.getVertex(filepath).size();i++) {
			g.addVertex(p.getVertex(filepath).get(i));
		}
		for(int i=0;i<p.getEdge(filepath).size();i++) {
			g.addEdge(p.getEdge(filepath).get(i));
		}
		return g;	
	}
}
