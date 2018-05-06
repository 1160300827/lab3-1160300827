package vertex;

public class Movie extends Vertex{
	private int year;
	private String country;
	private double IMDb;
	public Movie(String label) {
		this.name=label;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public double getS() {
		return IMDb;
	}
	public void setS(double s) {
		this.IMDb = s;
	}
}
