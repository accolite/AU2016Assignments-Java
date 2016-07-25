package comm.accolite.Servlets;

public class Chat {
	String name;
	String chat;
	
	
	public Chat() {
		super();
	}
	public Chat(String name, String chat) {
		super();
		this.name = name;
		this.chat = chat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	

}
