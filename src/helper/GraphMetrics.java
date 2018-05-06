package helper;

import vertex.Vertex;

import java.util.ArrayList;

import edge.Edge;
import graph.Graph;

public class GraphMetrics {
	public static double gE(Graph<Vertex,Edge> g,Vertex v) {
		double i=0;
		for(Vertex v1:g.vertices()) {
			if(gd(g,v,v1)>i) {
				i=gd(g, v, v1);
			}
		}
		return i;
		
	}
	public static double gr(Graph<Vertex,Edge> g) {
		double i=99999;
		for(Vertex v1:g.vertices()) {
			if(gE(g,v1)<i) {
				i=gE(g,v1);
			}
		}
		return i;	
	}
	public static double gD(Graph<Vertex,Edge> g) {
		double i=0;
		for(Vertex v1:g.vertices()) {
			for(Vertex v2:g.vertices()) {
				if(gd(g,v1,v2)>i) {
					i=gd(g,v1,v2);
				}
			}
		}
		return i;	
	}
	public static double degreeCentrality(Graph<Vertex,Edge> g, Vertex v) {
		return 	(double)g.sources(v).keySet().size()/(g.vertices().size()-1);
	}
	public static double indegree(Graph<Vertex,Edge> g, Vertex v) {
		return 	(double)g.sources(v).size()/(g.vertices().size()-1);
	}
	public static double outdegree(Graph<Vertex,Edge> g, Vertex v) {
		return 	(double)g.targets(v).size()/(g.vertices().size()-1);
	}
	public static double degreeCentrality(Graph<Vertex,Edge> g) {
		double n=0,s=0,y=g.vertices().size();
		for(Vertex v:g.vertices()){
			if(g.sources(v).size()>n) {
				n=g.sources(v).size();
			}
		}
		for(Vertex v:g.vertices()) {
			s+=n-g.sources(v).size();
		}
		return s/(y-1)/(y-2);		
	}
	public static double closenessCentrality (Graph<Vertex,Edge> g,Vertex v) {
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
	public static double betweennessCentrality(Graph<Vertex,Edge> g,Vertex v) {
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
	static boolean v(Graph<Vertex,Edge> g, Vertex v0,Vertex v1,Vertex v) {
		if(v0.getname().equals(v.getname())||v1.getname().equals(v0.getname())||v1.getname().equals(v.getname())) {
			return false;
		}
		return (gd(g,v0,v1)==gd(g, v0,v)+gd(g,v1,v));
	}
}
