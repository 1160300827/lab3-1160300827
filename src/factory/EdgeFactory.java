package factory;

import edge.CommentConnection;
import edge.Edge;
import edge.ForwardConnection;
import edge.FriendConnection;
import edge.MovieActorRelation;
import edge.MovieDirectorRelation;
import edge.NetworkConnection;
import edge.WordEdge;

abstract class EdgeFactory {
	protected abstract Edge factoryMethod(String name);
	public void anOperation(String Name){
	    @SuppressWarnings("unused")
		Edge e = factoryMethod(Name);
	  }
}
class WordEdgeFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new WordEdge(name);
	}
	
}
class FriendConnectionFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new FriendConnection(name);
	}
	
}
class CommentConnectionFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new CommentConnection(name);
	}
	
}
class ForwardConnectionFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new ForwardConnection(name);
	}
	
}
class MovieActorRelationFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new MovieActorRelation(name);
	}
	
}
class MovieDirectorRelationFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new MovieDirectorRelation(name);
	}
	
}
class NetworkConnectionFactory extends EdgeFactory{

	@Override
	protected Edge factoryMethod(String name) {
		return new NetworkConnection(name);
	}
	
}
