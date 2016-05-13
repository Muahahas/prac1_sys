package beans;

public class Coord {
	
	private float latitude;
	private float longitude;
	
	public Coord(float x, float y){
		this.latitude=x;
		this.longitude=y;
	}
	
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

}
