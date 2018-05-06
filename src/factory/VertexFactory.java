package factory;

import vertex.Actor;
import vertex.Computer;
import vertex.Director;
import vertex.Movie;
import vertex.Person;
import vertex.Router;
import vertex.Server;
import vertex.Vertex;
import vertex.Word;

abstract class VertexFactory {
	protected abstract Vertex factoryMethod(String name);
	public void anOperation(String Name){
	    @SuppressWarnings("unused")
		Vertex e = factoryMethod(Name);
	  }
}
class ActorFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Actor(name);
	}
	
}
class ComputerFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Computer(name);
	}
	
}
class DirectorFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Director(name);
	}
	
}
class MovieFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Movie(name);
	}
	
}
class PersonFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Person(name);
	}
	
}
class RouterFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Router(name);
	}
	
}
class ServerFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Server(name);
	}
	
}
class WordFactory extends VertexFactory{

	@Override
	protected Vertex factoryMethod(String name) {
		return new Word(name);
	}
	
}