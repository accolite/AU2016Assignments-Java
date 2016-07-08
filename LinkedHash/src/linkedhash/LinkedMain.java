package linkedhash;
public class LinkedMain {
	private Block[] table;
	int size= 10;
	private Block head;
	private Block tail;
	static class Block
	{
		Object Key;
		Object Value;
		Block next;
		Block before;
		Block after;
		public Block(Object Key,Object Value,Block next)
		{
			this.Key=Key;
			this.Value= Value;
			this.next=next;
		}
	}
	public LinkedMain()
	{
		table= new Block[size];
	}
	public void put(Object Key, Object Value)
	{
		if(Key==null)
			System.out.println("Null Key\n");
		Object hash=hash(Key);
		Block newBlock= new Block(Key,Value,null);
		rearrangeafterinsertion(newBlock);
		if(table[(int)hash]==null)
			table[(	int)hash]=newBlock;
		else
		{
			Block previous=null;
			Block current=table[(int)hash];
			while(current!=null)
			{
				if(current.Key.equals(Key))
				{
					if(previous==null)
					{
						newBlock.next=current.next;
						table[(int)hash]=newBlock;
						return;
					}
					else
					{
						newBlock.next=current.next;
						previous.next=newBlock;
						return;
					}
				}
				previous=current;
				current=current.next;
			}
			previous.next=newBlock;
			}
		
	}
	
	
	private void rearrangeafterinsertion(Block newBlock)
	{
		if(head==null)
		{
			head=newBlock;
			tail=newBlock;
			return;
		}
		if(head.Key.equals(newBlock.Key))
		{
			deletefirst();//
			insertfirst(newBlock);//
		}
		if(tail.Key.equals(newBlock.Key))
		{
			deletelast(); //
			insertlast(newBlock); // 
		}
		
		Block beforedelete=deleteentry(newBlock);
		//Block beforedelete = Findbefore(Block current);
		if(beforedelete==null)
		{
			insertlast(newBlock) ;//
		}
		else
		{
			insertafter(beforedelete,newBlock);
			
		}
		
	}
	public Object get(Object Key)
	{
		Object hash=hash(Key);
		if(table[(int)hash]==null)
			return null;
		else
		{
			Block temp=table[(int)hash];
			while(temp!=null)
			{
				if(temp.Key.equals(Key))
					return temp.Value;
				temp=temp.next;
			}
			return null;
		}
	}
	private Object hash(Object Key)
	{
		return Math.abs(Key.hashCode())%size;
	}
	public void display()
	{
		Block current=head;
		while(current!=null)
		{
			System.out.println(current.Key +" = "+ current.Value  );
			current=current.after;
		}
		
	}
	private void deletefirst()
	{
		if(head==tail)  //deletefirst
		{
			head=tail=null;
			return;
		}
		head=head.after;
		head.before=null;
	}
	private void insertfirst(Block newBlock)
	{
		if(head== null)  //insertatfirst //no entry is found
		{
			head=newBlock;
			tail=newBlock;
			return;
		}
		newBlock.after=head;
		head.before=newBlock;
		head=newBlock;
	}
	private void deletelast()
	{
		if(head==tail) //deletelast
		{
			head=tail=null;
			return;
		}
		tail=tail.before;
		tail.after=null;
	}
	private void insertlast(Block newBlock)
	{
		if(head==null) //insertatlast
		{
			head=newBlock;
			tail=newBlock;
			return;
		}
		tail.after=newBlock;
		newBlock.before=tail;
		tail=newBlock;
	}
	private void insertafter(Block beforedelete,Block newBlock)
	{
		Block current=head;
		while(current!=beforedelete)
			current=current.after;
		newBlock.after=beforedelete.after;
		beforedelete.after.before=newBlock;
		newBlock.before=beforedelete;
		beforedelete.after=newBlock;
	}
	private Block deleteentry(Block newBlock)
	{
		Block current=head;
		while(!current.Key.equals(newBlock.Key))
		{
			if(current.after==null)
				return null ;
			current=current.after;
		}
		
		Block beforedelete=current.before;
		current.before.after=current.after;
		current.after.before=current.before;
		return beforedelete;
	}
	
}
