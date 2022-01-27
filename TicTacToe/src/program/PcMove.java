package program;

import java.util.Random;

public class PcMove {
	
	static void display(char board[][])
	{
		for (int i=0; i<=board.length-1; i++)
		{
			for(int j=0; j<=board[i].length-1; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	

	    static void main(String[] args) {
		Random r = new Random();
		int x = r.nextInt(9)+1;
		System.out.println(x);
	}
	static void insert(char board[][],int Num, char ch) {
		
		switch(Num)
		{
		case 1: board[0][0]= ch;  //First line
		break;
		case 2: board[0][2]= ch;
		break;
		case 3: board[0][4]= ch;
		break;
		case 4: board[2][0]= ch;  //Second Line
		break;
		case 5: board[2][2]= ch;
		break;
		case 6: board[2][4]= ch;
		break;
		case 7: board[4][0]= ch;  //Third Line
		break;
		case 8: board[4][2]= ch;
		break;
		case 9: board[4][4]= ch;
		break;
		
		
		default: System.out.println("Invalid position");
		}
}

	}

