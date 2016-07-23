
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageDetails {

	public Map<Integer, Message> messages;

	public MessageDetails() {
		super();
		messages=new HashMap<Integer,Message>();
		Message msg=new Message(1,"Solar Eclipse","Newton");
		messages.put(1,msg);
		Comment comment=new Comment(1,"I agree to it","Loghithavani");
		Map<Integer, Comment> comments=new HashMap<Integer, Comment>();
		comments.put(1, comment);
		msg.setComments(comments);		
	}
	
	public Message getMessage(int id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		//message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;

	}
	
	public List<Message> getAllMessages()
	{
		return new ArrayList<Message>(messages.values());

	}
}