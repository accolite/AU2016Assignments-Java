package main.resources;


public class Comments
{
    private String commentorId;

    private String comment;

    public String getCommentorId ()
    {
        return commentorId;
    }

    public void setCommentorId (String commentorId)
    {
        this.commentorId = commentorId;
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
        return "ClassPojo [commentorId = "+commentorId+", comment = "+comment+"]";
    }
}