package beans;

public class Characteristic {
	
	private int idCaract;
	private String name;
	private int type;
	private int level;
	
	public Characteristic(int id, String name, int type, int level){
		this.idCaract=id;
		this.name=name;
		this.type=type;
		this.level=level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIdCaract() {
		return idCaract;
	}

	public void setIdCaract(int idCaract) {
		this.idCaract = idCaract;
	}

}
