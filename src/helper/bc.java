package helper;

import java.util.ArrayList;

import edge.Edge;
import graph.Graph;
import vertex.Vertex;

public class bc implements SF{

	@Override
	public double result(Graph<Vertex, Edge> g,Vertex v) {
		int i=0;
		for(Vertex v1:g.vertices()) {
			for(Vertex v2:g.vertices()) {
				if(v(g,v1,v2,v)) {
					i++;
				}
			}
		}
		return i;		
	}

	static boolean v(Graph<Vertex,Edge> g, Vertex v0,Vertex v1,Vertex v) {
		if(v0.getname().equals(v.getname())||v1.getname().equals(v0.getname())||v1.getname().equals(v.getname())) {
			return false;
		}
		return (gd(g,v0,v1)==gd(g, v0,v)+gd(g,v1,v));
	}

	public static double gd(Graph<Vertex,Edge> g,Vertex v0,Vertex v1) {
		ArrayList<String> l = new ArrayList<String>(); 
		l.add(v0.getname());
		boolean f1=false;
		double d=0;
		int ll=0;
		while(!f1) { 
			f1=true;
			if(l.indexOf(v1.getname())!=-1)
				return d;
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
					}
				}
				ll++;
			}	
		}
			return -1;
	}

}
