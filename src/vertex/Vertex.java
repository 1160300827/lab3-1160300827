package vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Vertex {
	protected String name;
	protected Map<Vertex, List<Double>> map = new HashMap<Vertex, List<Double>>();
	
	public Vertex(String name) {
		super();
		this.name=name;
	}
	public Vertex(Map<Vertex, List<Double>> m) {
		super();
		this.map=m;
	}
	public Vertex()
	{}
	
	public String getname() {
		return name;
	}
	public Map<Vertex, List<Double>> getMap(){
		return map;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setmap(Map<Vertex, List<Double>> m) {
		this.map=m;
	}
	public void addedge(Vertex v,List<Double> weight) {
		map.put(v, weight);
	}
	public void removeedge(Vertex v,int weight) {
		map.remove(v, weight);
	}
	public void removeedge(Vertex v) {
		map.remove(v);
	}
	public List<Vertex> getTargets() {
		List<Vertex> ts=new ArrayList<>();
		for(Vertex v:map.keySet()) {
			ts.add(v);
		}
		return ts;
	}
}
