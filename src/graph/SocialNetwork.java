package graph;

import edge.CommentConnection;
import edge.Edge;
import edge.ForwardConnection;
import edge.FriendConnection;
import vertex.Person;

public class SocialNetwork extends ConcreteGraph{
	private String name;
	private final Graph<Person, FriendConnection> graphf = Graph.empty();
	private final Graph<Person, CommentConnection> graphc = Graph.empty();
	private final Graph<Person, ForwardConnection> graphw = Graph.empty();
	
	public SocialNetwork(String name) {
		this.setName(name);
	}
	public Graph<Person, FriendConnection> getGraphf() {
		return graphf;
	}
	public Graph<Person, CommentConnection> getGraphc() {
		return graphc;
	}
	public Graph<Person, ForwardConnection> getGraphw() {
		return graphw;
	}
	public void acSet(double x) {
		for(Edge e:graphf.edges()) {
			double n=e.getWeight();
			e.setWeight(n*(1-x));
		}
		for(Edge e:graphc.edges()) {
			double n=e.getWeight();
			e.setWeight(n*(1-x));
		}
		for(Edge e:graphw.edges()) {
			double n=e.getWeight();
			e.setWeight(n*(1-x));
		}
	}
	public void addfedge(FriendConnection f) {
		acSet(f.getWeight());
		graphf.addEdge(f);
	}
	public void addcedge(CommentConnection f) {
		acSet(f.getWeight());
		graphc.addEdge(f);
	}
	public void addwedge(ForwardConnection f) {
		acSet(f.getWeight());
		graphw.addEdge(f);
	}
	public void rcSet(double x) {
		for(Edge e:graphf.edges()) {
			double n=e.getWeight();
			e.setWeight(n/(1-x));
		}
		for(Edge e:graphc.edges()) {
			double n=e.getWeight();
			e.setWeight(n/(1-x));
		}
		for(Edge e:graphw.edges()) {
			double n=e.getWeight();
			e.setWeight(n/(1-x));
		}
	}
	public void removefedge(FriendConnection f) {
		rcSet(f.getWeight());
		graphf.removeEdge(f);
	}
	public void removecedge(CommentConnection f) {
		rcSet(f.getWeight());
		graphc.removeEdge(f);
	}
	public void removewedge(ForwardConnection f) {
		rcSet(f.getWeight());
		graphw.removeEdge(f);
	}
	public void cSet(double x,double y) {
		for(Edge e:graphf.edges()) {
			double n=e.getWeight();
			e.setWeight(n*(1-y)/(1-x));
		}
		for(Edge e:graphc.edges()) {
			double n=e.getWeight();
			e.setWeight(n*(1-y)/(1-x));
		}
		for(Edge e:graphw.edges()) {
			double n=e.getWeight();
			e.setWeight(n*(1-y)/(1-x));
		}
	}
	@SuppressWarnings("unused")
	public void changefedge(FriendConnection f,double y) {
		for(Edge e:graphf.edges()) {
			cSet(f.getWeight(),y);
			if(e.getname().equals(f.getname())) {
				graphf.removeEdge(f);
			}
		}
		for(Edge e:graphc.edges()) {
			cSet(f.getWeight(),y);
		}
		for(Edge e:graphw.edges()) {
			cSet(f.getWeight(),y);
		}
	}
	@SuppressWarnings("unused")
	public void changecedge(CommentConnection f,double y) {
		for(Edge e:graphf.edges()) {
			cSet(f.getWeight(),y);
			
		}
		for(Edge e:graphc.edges()) {
			if(e.getname().equals(f.getname())) {
				graphc.removeEdge(f);
			}
			cSet(f.getWeight(),y);
		}
		for(Edge e:graphw.edges()) {
			cSet(f.getWeight(),y);
		}
	}
	@SuppressWarnings("unused")
	public void changeedge(ForwardConnection f,double y) {
		for(Edge e:graphf.edges()) {
			cSet(f.getWeight(),y);
			
		}
		for(Edge e:graphc.edges()) {
			cSet(f.getWeight(),y);
		}
		for(Edge e:graphw.edges()) {
			if(e.getname().equals(f.getname())) {
				graphw.removeEdge(f);
			}
			cSet(f.getWeight(),y);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
