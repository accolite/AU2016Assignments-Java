package com.accolite.chess;


public class chessgame {

	public static void main(String args[])
	{
		
		
		board b=new board();
		
		b.display();
		
		player p_w=new player('w');
		player p_b=new player('b');
		
		b.display();
		
		int i=1;
		System.out.println("starting with player with black");
		/*while(1)
		{
			if(i==1)
			{
				System.out.println("player with black chance");
				if(p_b.play())
				{
					System.out.println("player with black win");
					break;
				}
				else
					i=0;
			}
			else
			{
				System.out.println("player with white chance");
				if(p_w.play())
				{
					System.out.println("player with white win");
					break;
				}
				else
					i=1;
			}
			b.display();
		}*/
		
		
	}
}
