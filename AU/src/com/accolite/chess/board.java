
package com.accolite.chess;

public class board {
	

		static pieces p[][] = new pieces[8][8];
		
		board()
		{ 
			for(int i=0;i<8;i++)
				for(int j=0;j<8;j++)
				{
					p[i][j] = new pieces();
					p[i][j].type='x';
					
				}
		}
		
		
		void set_board_b(){
			
			System.out.println("Seting board for black");
			for(int i=0;i<2;i++)
				for(int j=0;j<8;j++)
				{
					p[i][j].color='b';
					p[i][j].in_game='y';
					if(i==1)
					{
						
						p[i][j].type='p';
						
					}
					
				}
			
			p[0][0].type ='r';
			p[0][1].type ='n';
			p[0][2].type ='b';
			p[0][3].type ='k';
			p[0][4].type ='q';
			p[0][5].type ='b';
			p[0][6].type ='n';
			p[0][7].type ='r';
			
	}
		
	void set_board_w(){
			
		System.out.println("Seting board for white");	
		for(int i=6;i<8;i++)
				for(int j=0;j<8;j++)
				{
					p[i][j].color='w';
					p[i][j].in_game='y';
					if(i==6)
					{
						
						p[i][j].type='P';
						
					}
					
				}
			
			p[7][0].type ='R';
			p[7][1].type ='N';
			p[7][2].type ='B';
			p[7][3].type ='K';
			p[7][4].type ='Q';
			p[7][5].type ='B';
			p[7][6].type ='N';
			p[7][7].type ='R';
			
	}
	
	char return_type(int x,int y)
	{
		return p[x][y].type;
	}
	char return_color(int x,int y)
	{
		return p[x][y].color;
	}
	void display()
	{
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(p[i][j].in_game == 'y' && p[i][j].color == 'b')
				{
					 System.out.print(p[i][j].type);
					 System.out.print("\t");
				}
			  else if(p[i][j].in_game == 'y' && p[i][j].color == 'w')
			  {
				  System.out.print(p[i][j].type);
				  System.out.print("\t");
			}
			  else
			  {
				  System.out.print("X");
				  System.out.print("\t");
			  }
				
	}
		System.out.println("\n");
		}		
	}

}

