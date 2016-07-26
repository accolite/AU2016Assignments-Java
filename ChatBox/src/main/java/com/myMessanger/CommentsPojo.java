package com.myMessanger;

import java.util.Comparator;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

@XmlRootElement                



public class CommentsPojo implements Comparator<CommentsPojo>
{
    String comment_id;

    String time;

    String user_id;

    String comment;
public CommentsPojo() {
	// TODO Auto-generated constructor stub
}
   public CommentsPojo(String comment_id,String time,String user_id,String comment) {
	// TODO Auto-generated constructor stub
	   this.comment=comment;
	   this.time=time;
	   this.user_id=user_id;
	   this.comment_id=comment_id;
}
   public String getComment_id ()
   {
       return comment_id;
   }

   public void setComment_id (String comment_id)
   {
       this.comment_id = comment_id;
   }

   public String getTime ()
   {
       return time;
   }

   public void setTime (String time)
   {
       this.time = time;
   }

   public String getUser_id ()
   {
       return user_id;
   }

   public void setUser_id (String user_id)
   {
       this.user_id = user_id;
   }

   public String getComment ()
   {
       return comment;
   }

   public void setComment (String comment)
   {
       this.comment = comment;
   }

   @Override
   public String toString()
   {
       return "ClassPojo [comment_id = "+comment_id+", time = "+time+", user_id = "+user_id+", comment = "+comment+"]";
   }
   @Override
	public int compare(CommentsPojo o1,CommentsPojo o2) {
		DateTime date1 = DateTime.parse(o1.time,DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss"));
		DateTime date2 = DateTime.parse(o2.time,DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss"));
		System.out.println(date1.toString() + date2.toString());
	    if(date1.isBefore(date2)) {
	    	System.out.println("hi");
	        return 1;
	    } else if (date2.isBefore(date1)) {
	    	System.out.println("hello");
	        return -1;
	    }
	    return 0;
	}
	
}
			
			