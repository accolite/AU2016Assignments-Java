
import java.util.Date;

public class Comment {

	private int id;
	private String comment;
	private Date created;
	private String author;
	
	public Comment() {
		super();
	}

	public Comment(int id, String comment, String author) {
		super();
		this.id = id;
		this.comment = comment;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}