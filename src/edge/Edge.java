package edge;

import vertex.Vertex;

public abstract class Edge {
	protected String name;
	protected Vertex startVertex;  
	protected Vertex endVertex;  
	protected double weight;  
	protected String inf;
	
	public Edge(String label,double weight) {
		this.name=label;
		this.weight=weight;
	}
	public Edge(Vertex startVertex, Vertex endVertex, double weight) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
		this.name = startVertex.getname()+"--"+endVertex.getname()+" : "+weight;
	}	
	public Edge()
	{}
	
	public String getinf() {
		inf=startVertex.getname()+" --> "+endVertex.getname()+" ("+weight+")";
		return inf;
	}
	public boolean containVertex(Vertex v) {
		return v.getname().equals(startVertex.getname()) || v.getname().equals(endVertex.getname());
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name=name;
	}
	public Vertex getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}
	public Vertex getEndVertex() {
		return endVertex;
	}
	public void setEndVertex(Vertex endVertex) {
		this.endVertex = endVertex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double d) {
		this.weight = d;
	}
}
