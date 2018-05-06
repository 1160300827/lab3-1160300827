package application;

import java.util.Scanner;

import edge.Edge;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import factory.MovieGraphFactory;
import graph.MovieGraph;
import helper.GraphMetrics;
import vertex.Actor;
import vertex.Director;
import vertex.Movie;
import vertex.Vertex;

public class MovieGraphApp {
	public static void main(String[] args) {
		MovieGraph g = MovieGraphFactory.createGraph("src/application/GraphPoet");
		System.out.println("现有顶点：");
		for(Vertex v: g.vertices()) {
			System.out.println(v.getname());
		}
		System.out.println("现有边：");
		for(Edge e: g.edges()) {
			System.out.println(e.getinf());
		}
		System.out.println("请输入要添加的电影(输入0结束）：");
		Scanner in = new Scanner(System.in);
		String s=in.next();
		while(!s.equals("0")) {
			Movie v = new Movie(s);
			g.addVertex(v);
			s=in.next();
		}
		s="-1";
		System.out.println("请输入要添加的演员(输入0结束）：");
		while(!s.equals("0")) {
			Actor v = new Actor(s);
			g.addVertex(v);
			s=in.next();
		}
		s="-1";
		System.out.println("请输入要添加的导演(输入0结束）：");
		while(!s.equals("0")) {
			Director v = new Director(s);
			g.addVertex(v);
			s=in.next();
		}
		s="-1";
		System.out.println("请输入要删除的节点(输入0结束）：");
		while(!s.equals("0")) {
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					g.removeVertex(v);
				}
			}
			s=in.next();
		}
		s="-1";
		while(!s.equals("0")){			
			System.out.println("请选择你要修改的电影(输入0结束）：");
			s=in.next();
			for(Movie m: g.getGraphm().vertices()) {
				if(m.getname().equals(s)) {
					System.out.println("请输入新的名称：");
					m.setname(in.next());
					System.out.println("请输入新的上映时间：");
					m.setYear(in.nextInt());
					System.out.println("请输入新的拍摄国家：");
					m.setCountry(in.next());
					System.out.println("请输入新的IMDb评分：");
					m.setS(in.nextDouble());
				}
			}
		}
		s="-1";
		while(!s.equals("0")){			
			System.out.println("请选择你要修改的演员(输入0结束）：");
			s=in.next();
			for(Actor m: g.getGrapha().vertices()) {
				if(m.getname().equals(s)) {
					System.out.println("请输入新的名称：");
					m.setname(in.next());
					System.out.println("请输入当前年龄：");
					m.setAge(in.nextInt());
					System.out.println("请输入当前性别：");		
					m.setGender(in.next());
				}
			}
		}
		s="-1";
		while(!s.equals("0")){			
			System.out.println("请选择你要修改的导演(输入0结束）：");
			s=in.next();
			for(Director m: g.getGraphd().vertices()) {
				if(m.getname().equals(s)) {
					System.out.println("请输入新的名称：");
					m.setname(in.next());
					System.out.println("请输入当前年龄：");
					m.setAge(in.nextInt());
					System.out.println("请输入当前性别：");		
					m.setGender(in.next());
				}
			}
		}
		s="-1";
		System.out.println("请输入要添加的参演边的名称(输入0结束）：");
		s=in.next();
		while(!s.equals("0")) {
			MovieActorRelation w = new MovieActorRelation(s);
			System.out.println("请输入起始节点：");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					w.setStartVertex(v);
				}
			}
			System.out.println("请输入终止节点：");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					w.setEndVertex(v);
				}
			}
			System.out.println("请输入权值：");
			w.setWeight(in.nextDouble());
			g.addEdge(w);
			System.out.println("请输入要添加的边的名称(输入0结束）：");
			s=in.next();
		}
		s="-1";
		System.out.println("请输入要添加的导演边的名称(输入0结束）：");
		s=in.next();
		while(!s.equals("0")) {
			MovieDirectorRelation w = new MovieDirectorRelation(s);
			System.out.println("请输入起始节点：");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					w.setStartVertex(v);
				}
			}
			System.out.println("请输入终止节点：");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					w.setEndVertex(v);
				}
			}
			System.out.println("请输入权值：");
			w.setWeight(in.nextDouble());
			g.addEdge(w);
			System.out.println("请输入要添加的边的名称(输入0结束）：");
			s=in.next();
		}
		s="-1";
		System.out.println("请输入要删除的边的名称(输入0结束）：");
		while(!s.equals("0")) {
			s=in.next();
			for(Edge e: g.edges()) {
				if(e.getname().equals(s)) {
					g.removeEdge(e);
				}
			}
		}
		s="-1";
		System.out.println("请输入要修改的边的名称(输入0结束）：");
		s=in.next();
		while(!s.equals("0")) {
			for(Edge e: g.edges()) {
				if(e.getname().equals(s)) {
					System.out.println("请输入新的边的名称：");
					e.setname(in.next());
					System.out.println("请输入新的权值：");
					e.setWeight(in.nextDouble());
					System.out.println("是否更改边的方向？（是/否）");
					s=in.next();
					if(s.equals("是")) {
						Vertex t = e.getStartVertex();
						e.setStartVertex(e.getEndVertex());
						e.setEndVertex(t);
					}
				}	
			}
			System.out.println("请输入要修改的边的名称(输入0结束）：");
			s=in.next();
		}
		s="-1";
		System.out.println("请输入要计算的节点：(输入0结束)");
		s=in.next();
		while(!s.equals("0")) {
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					System.out.printf("中心度：%.2f\n",GraphMetrics.degreeCentrality(g,v));
					System.out.printf("中介中心度：%.2f\n",GraphMetrics.betweennessCentrality(g, v)*2/g.vertices().size()/(g.vertices().size()-1));
					System.out.printf("紧密中心性：%.2f\n", GraphMetrics.closenessCentrality(g, v));
					System.out.printf("离心率：%.2f\n",GraphMetrics.gE(g, v));
					System.out.printf("入中心度：%.2f\n",GraphMetrics.indegree(g,v));
					System.out.printf("出中心度：%.2f\n",GraphMetrics.outdegree(g,v));
				}
			}
			System.out.println("请输入要计算的节点：(输入0结束)");
			s=in.next();
		}
		System.out.printf("图的中心度：%.2f\n",GraphMetrics.degreeCentrality(g));
		System.out.printf("图的半径：%.2f\n",GraphMetrics.gr(g));
		System.out.printf("图的直径：%.2f\n",GraphMetrics.gD(g));
		System.out.println("当前顶点：");
		for(Vertex v: g.vertices()) {
			System.out.println(v.getname());
		}
		System.out.println("当前边：");
		for(Edge e: g.edges()) {
			System.out.println(e.getinf());
		}		
		System.out.println("计算两点距离：");
		System.out.print("起始节点：");
		s=in.next();
		Vertex S = null;
		for(Vertex v: g.vertices()) {
			if(v.getname().equals(s)) {
				S=v;
			}
		}
		System.out.print("目标节点：");
		s=in.next();
		Vertex E = null;
		for(Vertex v: g.vertices()) {
			if(v.getname().equals(s)) {
				E=v;
			}
		}
		System.out.printf("求得距离为：%.2f",GraphMetrics.gd(g, S, E));
		in.close();
	}
}
