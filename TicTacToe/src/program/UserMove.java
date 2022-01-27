package program;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserMove {
	
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
		
		static void insert(char board[][],int Num, char ch) 
		{

			switch(Num)
			{
			case 1: board[0][0]=ch;  //First line
			break;
			case 2: board[0][2]=ch;
			break;
			case 3: board[0][4]=ch;
			break;
			case 4: board[2][0]=ch;  //Second Line
			break;
			case 5: board[2][2]=ch;
			break;
			case 6: board[2][4]=ch;
			break;
			case 7: board[4][0]=ch;  //Third Line
			break;
			case 8: board[4][2]=ch;
			break;
			case 9: board[4][4]=ch;
			break;
			
			default: System.out.println("Invalid position");
			}

	}
		static void checkWinner() {
			List topRow    = Arrays.asList(1,2,3);
			List middleRow = Arrays.asList(4,5,6);
			List bottomRow = Arrays.asList(7,8,9);
			List topCol    = Arrays.asList(1,4,7);
			List middleCol = Arrays.asList(2,5,8);
			List bottomCol = Arrays.asList(3,6,9);
			List cross1    = Arrays.asList(1,5,9);
			List cross2    = Arrays.asList(3,5,7);
			
			List<List> winningCondition = new ArrayList<List>();
			winningCondition.add(topRow);
			winningCondition.add(middleRow);
			winningCondition.add(bottomRow);
			winningCondition.add(topCol);
			winningCondition.add(middleCol);
			winningCondition.add(bottomRow);
			winningCondition.add(cross1);
			winningCondition.add(cross2);
			
			for (List l : winningCondition)
			{
				if(OnePlayerGame.allP1Num.containsAll(l)||TwoPlayerGame.allP1Num.containsAll(l))
				{
					System.out.println("Player 1 wins!");
					System.exit(0);
				}
			
			else if(OnePlayerGame.allCpuNum.containsAll(l))
			{
				System.out.println("Sorry~ CPU has won. Try again");
				System.exit(0);
			} 
			else if(TwoPlayerGame.allP2Num.containsAll(l)){
				System.out.println("Player Two has won! Congratulations!");
				System.exit(0);
			}
		
			}
			
			if(OnePlayerGame.allCpuNum.size()+ OnePlayerGame.allP1Num.size()==9 ||TwoPlayerGame.allP2Num.size()+ TwoPlayerGame.allP1Num.size()==9 )
			{
				System.out.println("It is a draw!");
				System.exit(0);
		}
}
}