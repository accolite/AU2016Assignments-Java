package pkg;

public class Cmt {
	String creator, message;
	public Cmt(){}
	public Cmt(String creator, String message) {
		this.creator = creator;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
}

