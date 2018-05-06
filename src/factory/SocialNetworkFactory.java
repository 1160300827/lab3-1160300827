package factory;

import graph.SocialNetwork;
import helper.ParseCommandHelper;

public class SocialNetworkFactory {
	public static SocialNetwork createGraph(String filepath) {
		ParseCommandHelper p = new ParseCommandHelper();
		SocialNetwork g = new SocialNetwork(p.getGraohName(filepath));
		for(int i=0;i<p.getVertex(filepath).size();i++) {
			g.addVertex(p.getVertex(filepath).get(i));
		}
		for(int i=0;i<p.getEdge(filepath).size();i++) {
			g.addEdge(p.getEdge(filepath).get(i));
		}
		return g;	
	}
}
