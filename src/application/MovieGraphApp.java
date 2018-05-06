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
		System.out.println("���ж��㣺");
		for(Vertex v: g.vertices()) {
			System.out.println(v.getname());
		}
		System.out.println("���бߣ�");
		for(Edge e: g.edges()) {
			System.out.println(e.getinf());
		}
		System.out.println("������Ҫ��ӵĵ�Ӱ(����0��������");
		Scanner in = new Scanner(System.in);
		String s=in.next();
		while(!s.equals("0")) {
			Movie v = new Movie(s);
			g.addVertex(v);
			s=in.next();
		}
		s="-1";
		System.out.println("������Ҫ��ӵ���Ա(����0��������");
		while(!s.equals("0")) {
			Actor v = new Actor(s);
			g.addVertex(v);
			s=in.next();
		}
		s="-1";
		System.out.println("������Ҫ��ӵĵ���(����0��������");
		while(!s.equals("0")) {
			Director v = new Director(s);
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
			System.out.println("��ѡ����Ҫ�޸ĵĵ�Ӱ(����0��������");
			s=in.next();
			for(Movie m: g.getGraphm().vertices()) {
				if(m.getname().equals(s)) {
					System.out.println("�������µ����ƣ�");
					m.setname(in.next());
					System.out.println("�������µ���ӳʱ�䣺");
					m.setYear(in.nextInt());
					System.out.println("�������µ�������ң�");
					m.setCountry(in.next());
					System.out.println("�������µ�IMDb���֣�");
					m.setS(in.nextDouble());
				}
			}
		}
		s="-1";
		while(!s.equals("0")){			
			System.out.println("��ѡ����Ҫ�޸ĵ���Ա(����0��������");
			s=in.next();
			for(Actor m: g.getGrapha().vertices()) {
				if(m.getname().equals(s)) {
					System.out.println("�������µ����ƣ�");
					m.setname(in.next());
					System.out.println("�����뵱ǰ���䣺");
					m.setAge(in.nextInt());
					System.out.println("�����뵱ǰ�Ա�");		
					m.setGender(in.next());
				}
			}
		}
		s="-1";
		while(!s.equals("0")){			
			System.out.println("��ѡ����Ҫ�޸ĵĵ���(����0��������");
			s=in.next();
			for(Director m: g.getGraphd().vertices()) {
				if(m.getname().equals(s)) {
					System.out.println("�������µ����ƣ�");
					m.setname(in.next());
					System.out.println("�����뵱ǰ���䣺");
					m.setAge(in.nextInt());
					System.out.println("�����뵱ǰ�Ա�");		
					m.setGender(in.next());
				}
			}
		}
		s="-1";
		System.out.println("������Ҫ��ӵĲ��ݱߵ�����(����0��������");
		s=in.next();
		while(!s.equals("0")) {
			MovieActorRelation w = new MovieActorRelation(s);
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
		System.out.println("������Ҫ��ӵĵ��ݱߵ�����(����0��������");
		s=in.next();
		while(!s.equals("0")) {
			MovieDirectorRelation w = new MovieDirectorRelation(s);
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
		in.close();
	}
}
