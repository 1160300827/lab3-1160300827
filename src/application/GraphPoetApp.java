package application;

import java.util.Scanner;

import edge.Edge;
import edge.WordEdge;
import factory.GraphPoetFactory;
import graph.GraphPoet;
import vertex.Vertex;
import vertex.Word;
import helper.GraphMetrics;

public class GraphPoetApp {
	public static void main(String[] args) {
		GraphPoet g = GraphPoetFactory.createGraph("src/application/GraphPoet");
		System.out.println("现有顶点：");
		for(Vertex v: g.vertices()) {
			System.out.println(v.getname());
		}
		System.out.println("现有边：");
		for(Edge e: g.edges()) {
			System.out.println(e.getinf());
		}
		System.out.println("请输入要添加的节点(输入0结束）：");
		Scanner in = new Scanner(System.in);
		String s=in.next();
		while(!s.equals("0")) {
			Word v = new Word(s);
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
			System.out.println("请选择你要修改的节点(输入0结束）：");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					System.out.println("请输入新的节点名称：");
					v.setname(in.next());
				}
			}
		}
		s="-1";
		System.out.println("请输入要添加的边的名称(输入0结束）：");
		s=in.next();
		while(!s.equals("0")) {
			WordEdge w = new WordEdge(s);
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
		System.out.println("确定n:");
		int n=in.nextInt();
		for(Edge e: g.edges()) {
			if(e.getWeight()<n) {
				g.removeEdge(e);
			}
		}
		in.close();
	}
}