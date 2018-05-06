package graph;

import edge.Edge;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import vertex.Actor;
import vertex.Director;
import vertex.Movie;
import vertex.Vertex;

public class MovieGraph extends ConcreteGraph{
	private String name;
	private final Graph<Movie, Edge> graphm = Graph.empty();
	private final Graph<Director, Edge> graphd = Graph.empty();
	private final Graph<Actor, Edge> grapha = Graph.empty();
	private final Graph<Vertex, MovieActorRelation> graphA = Graph.empty();
	private final Graph<Vertex, MovieDirectorRelation> graphD = Graph.empty();
	
	public MovieGraph(String name){
		this.name=name;
	}
	public Graph<Actor, Edge> getGrapha() {
		return grapha;
	}
	public Graph<Director, Edge> getGraphd() {
		return graphd;
	}
	public String getName() {
		return name;
	}
	public void setName(String label) {
		this.name = label;
	}
	public Graph<Movie, Edge> getGraphm() {
		return graphm;
	}
	public Graph<Vertex, MovieActorRelation> getGraphA() {
		return graphA;
	}
	public Graph<Vertex, MovieDirectorRelation> getGraphD() {
		return graphD;
	}
}
