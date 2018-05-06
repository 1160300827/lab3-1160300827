/**
 * 
 */
/**
 * @author User
 *
 */
package test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edge.Edge;
import edge.WordEdge;
import factory.GraphPoetFactory;
import graph.*;
import vertex.Vertex;
import vertex.Word;

public class test {
	 @Test(expected=AssertionError.class)
	    public void testAssertionsEnabled() {
	        assert false;
	    }
	 
	 @Test
	 public void Gtest() {
		 GraphPoet g = GraphPoetFactory.createGraph("src/application/GraphPoet");
			assertEquals("aGraphPoet",g.getName());
			assertEquals("A",g.vs().get(0).getname());
			assertEquals("B",g.vs().get(1).getname());
			assertEquals("C",g.vs().get(2).getname());
			assertEquals("D",g.vs().get(3).getname());

			assertEquals("AB",g.es().get(0).getname());
			assertEquals("AB*",g.es().get(1).getname());
			assertEquals("BC",g.es().get(2).getname());
			assertEquals("BC*",g.es().get(3).getname());
			assertEquals("CD",g.es().get(4).getname());
			assertEquals("CD*",g.es().get(5).getname());

			assertEquals(1, g.es().get(0).getWeight(),0.1);
			assertEquals(1, g.es().get(1).getWeight(),0.1);
			assertEquals(1.1, g.es().get(2).getWeight(),0.1);
			assertEquals(1.1, g.es().get(3).getWeight(),0.1);
			assertEquals(1.2, g.es().get(4).getWeight(),0.1);
			assertEquals(1.2, g.es().get(5).getWeight(),0.1);

			assertEquals("A",g.es().get(0).getStartVertex().getname());
			assertEquals("B",g.es().get(1).getStartVertex().getname());
			assertEquals("B",g.es().get(2).getStartVertex().getname());
			assertEquals("C",g.es().get(3).getStartVertex().getname());
			assertEquals("C",g.es().get(4).getStartVertex().getname());
			assertEquals("D",g.es().get(5).getStartVertex().getname());
	 }
}
