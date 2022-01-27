package program;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoPlayerGame {
	
	static ArrayList allP1Num = new ArrayList();
	static ArrayList allP2Num = new ArrayList();
	
	        
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		char board[][] = {
				{' ','|',' ','|',' '},
				{'-','+',' ','+','-'},
				{' ','|',' ','|',' '},
				{'-','+',' ','+','-'},
				{' ','|',' ','|',' '},
				};
		UserMove.display(board);
		while(true) {     	
			//Player 1 
			System.out.println("Player 1 plays as X. Enter a position between 1-9: ");
			int P1Num = sc.nextInt();
			
			//Invalid position entered statement
			if (!(P1Num > 0 && P1Num <= 9)) {
				System.out.println("Invalid position chosen. Please choose carefully otherwise your turn is skipped: ");
				P1Num = sc.nextInt();
			}
			
			//Ensure that Player1 does not re-enter the same value
			while(allP1Num.contains(P1Num) || allP2Num.contains(allP1Num) 
				  || allP2Num.contains(P1Num)){
                System.out.println("Position taken! Enter another position:");
                P1Num = sc.nextInt();
                
              //Ensure that Player1 does not overwrite Player 2
                while(allP1Num.contains(P1Num) || allP2Num.contains(P1Num)){
                    System.out.println("Position taken! Enter another position:");
                    P1Num= sc.nextInt();
                }
            }
			System.out.println("Player 2's turn!  chosen position: " +P1Num);
			
			    //Inputing values into the lists/Arrays by the user
                UserMove.insert(board, P1Num, 'X');
                UserMove.display(board);
                allP1Num.add(P1Num);
                System.out.println(allP1Num);
                UserMove.checkWinner();
		
		//Player 2
                System.out.println("Player 2 plays as O. Enter a position between 1-9: ");
                int P2Num = sc.nextInt();
		
		//Ensures that Player2 does not repeat a chosen value
		 while(allP1Num.contains(P2Num) || allP2Num.contains(P2Num)
			   || allP2Num.contains(allP1Num)){
			 System.out.println("Position taken! Enter another position:");
			 P2Num = sc.nextInt();
             
             //Ensure that Player2 does not overwrite Player 1
             while(allP1Num.contains(P2Num) || allP2Num.contains(P2Num)){
                 System.out.println("Position taken! Enter another position:");
                 P2Num = sc.nextInt();
         }
		 }
		System.out.println("Player 2's turn!  chosen position: " +P2Num);
		
		//Inputing values into the lists/Arrays by Player Two
		PcMove.insert(board, P2Num, 'O');
		PcMove.display(board);	
		allP2Num.add(P2Num);
		System.out.println(allP2Num);
		UserMove.checkWinner();
		}
	}
}
	
	
