package helper;

import java.util.ArrayList;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class cc implements SF{

	@Override
	public double result(Graph<Vertex, Edge> g, Vertex v) {
		ArrayList<String> l = new ArrayList<String>();
		l.add(v.getname());
		boolean f1=false;
		int d=0;
		int S=0;
		int ll=0;
		while(!f1) { 
			f1=true;
			d++;
			int x=l.size();
			for(int i=ll;i<x;i++) {
				Vertex q = null;
				for(Vertex p:g.vertices()) {
					if(p.getname().equals(l.get(i))) {
						q=p;
					}
				}
				for (Vertex v11 : q.getTargets()) {
					if(l.indexOf(v11.getname())==-1) {
						f1=false;
						l.add(v11.getname());
						S+=d;
					}
				}
				ll++;
				
			}	
		}
		return (double)(g.vertices().size()-1)/S;	
	}

}
