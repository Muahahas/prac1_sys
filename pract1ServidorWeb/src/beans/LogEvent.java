package beans;

public class LogEvent {

	private int id;
	private String date;
	private String time;
	private int type;
	private String message;
	
	public LogEvent(int id, String date, String time, int type, String message){
		this.id=id;
		this.date=date;
		this.time=time;
		this.type=type;
		this.message=message;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMeesage() {
		return message;
	}
	public void setMeesage(String message) {
		this.message = message;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
