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
		System.out.println("���ж��㣺");
		for(Vertex v: g.vertices()) {
			System.out.println(v.getname());
		}
		System.out.println("���бߣ�");
		for(Edge e: g.edges()) {
			System.out.println(e.getinf());
		}
		System.out.println("������Ҫ��ӵĽڵ�(����0��������");
		Scanner in = new Scanner(System.in);
		String s=in.next();
		while(!s.equals("0")) {
			Word v = new Word(s);
			g.addVertex(v);
			s=in.next();
		}
		s="-1";
		System.out.println("������Ҫɾ���Ľڵ�(����0��������");
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
			System.out.println("��ѡ����Ҫ�޸ĵĽڵ�(����0��������");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					System.out.println("�������µĽڵ����ƣ�");
					v.setname(in.next());
				}
			}
		}
		s="-1";
		System.out.println("������Ҫ��ӵıߵ�����(����0��������");
		s=in.next();
		while(!s.equals("0")) {
			WordEdge w = new WordEdge(s);
			System.out.println("��������ʼ�ڵ㣺");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					w.setStartVertex(v);
				}
			}
			System.out.println("��������ֹ�ڵ㣺");
			s=in.next();
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					w.setEndVertex(v);
				}
			}
			System.out.println("������Ȩֵ��");
			w.setWeight(in.nextDouble());
			g.addEdge(w);
			System.out.println("������Ҫ��ӵıߵ�����(����0��������");
			s=in.next();
		}
		s="-1";
		System.out.println("������Ҫɾ���ıߵ�����(����0��������");
		while(!s.equals("0")) {
			s=in.next();
			for(Edge e: g.edges()) {
				if(e.getname().equals(s)) {
					g.removeEdge(e);
				}
			}
		}
		s="-1";
		System.out.println("������Ҫ�޸ĵıߵ�����(����0��������");
		s=in.next();
		while(!s.equals("0")) {
			for(Edge e: g.edges()) {
				if(e.getname().equals(s)) {
					System.out.println("�������µıߵ����ƣ�");
					e.setname(in.next());
					System.out.println("�������µ�Ȩֵ��");
					e.setWeight(in.nextDouble());
					System.out.println("�Ƿ���ıߵķ��򣿣���/��");
					s=in.next();
					if(s.equals("��")) {
						Vertex t = e.getStartVertex();
						e.setStartVertex(e.getEndVertex());
						e.setEndVertex(t);
					}
				}	
			}
			System.out.println("������Ҫ�޸ĵıߵ�����(����0��������");
			s=in.next();
		}
		s="-1";
		System.out.println("������Ҫ����Ľڵ㣺(����0����)");
		s=in.next();
		while(!s.equals("0")) {
			for(Vertex v: g.vertices()) {
				if(v.getname().equals(s)) {
					System.out.printf("���Ķȣ�%.2f\n",GraphMetrics.degreeCentrality(g,v));
					System.out.printf("�н����Ķȣ�%.2f\n",GraphMetrics.betweennessCentrality(g, v)*2/g.vertices().size()/(g.vertices().size()-1));
					System.out.printf("���������ԣ�%.2f\n", GraphMetrics.closenessCentrality(g, v));
					System.out.printf("�����ʣ�%.2f\n",GraphMetrics.gE(g, v));
					System.out.printf("�����Ķȣ�%.2f\n",GraphMetrics.indegree(g,v));
					System.out.printf("�����Ķȣ�%.2f\n",GraphMetrics.outdegree(g,v));
				}
			}
			System.out.println("������Ҫ����Ľڵ㣺(����0����)");
			s=in.next();
		}
		System.out.printf("ͼ�����Ķȣ�%.2f\n",GraphMetrics.degreeCentrality(g));
		System.out.printf("ͼ�İ뾶��%.2f\n",GraphMetrics.gr(g));
		System.out.printf("ͼ��ֱ����%.2f\n",GraphMetrics.gD(g));
		System.out.println("��ǰ���㣺");
		for(Vertex v: g.vertices()) {
			System.out.println(v.getname());
		}
		System.out.println("��ǰ�ߣ�");
		for(Edge e: g.edges()) {
			System.out.println(e.getinf());
		}		
		System.out.println("����������룺");
		System.out.print("��ʼ�ڵ㣺");
		s=in.next();
		Vertex S = null;
		for(Vertex v: g.vertices()) {
			if(v.getname().equals(s)) {
				S=v;
			}
		}
		System.out.print("Ŀ��ڵ㣺");
		s=in.next();
		Vertex E = null;
		for(Vertex v: g.vertices()) {
			if(v.getname().equals(s)) {
				E=v;
			}
		}
		System.out.printf("��þ���Ϊ��%.2f",GraphMetrics.gd(g, S, E));
		System.out.println("ȷ��n:");
		int n=in.nextInt();
		for(Edge e: g.edges()) {
			if(e.getWeight()<n) {
				g.removeEdge(e);
			}
		}
		in.close();
	}
}