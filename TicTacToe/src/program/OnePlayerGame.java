package program;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class OnePlayerGame {
	
	static ArrayList allP1Num = new ArrayList();
	static ArrayList allCpuNum = new ArrayList();
	
	        
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
			System.out.println("Player plays as X. Enter a position between 1-9: ");
			int UserNum = sc.nextInt();
			
			//Invalid position entered statement
			if (!(UserNum > 0 && UserNum <= 9)) {
				System.out.println("Invalid position chosen. Please choose carefully otherwise your turn is skipped: ");
				UserNum = sc.nextInt();
			}
			
			//Ensure that Player does not re-enter the same value
			while(allP1Num.contains(UserNum) || allCpuNum.contains(allP1Num) 
				  || allCpuNum.contains(UserNum)){
                System.out.println("Position taken! Enter another position:");
                UserNum = sc.nextInt();
                
              //Ensure that Player1 does not overwrite Cpu
                while(allP1Num.contains(UserNum) || allCpuNum.contains(UserNum)){
                    System.out.println("Position taken! Enter another position:");
                    UserNum= sc.nextInt();
                }
            }
			System.out.println("Player's chosen position: " +UserNum);
			
			    //Inputing values into the lists/Arrays by the user
                UserMove.insert(board, UserNum, 'X');
                UserMove.display(board);
                allP1Num.add(UserNum);
                System.out.println(allP1Num);
                UserMove.checkWinner();
		
		//Cpu
                
                Random r = new Random();
    			int CpuNum = r.nextInt(9)+1;
		
		//Ensures that Cpu does not repeat a chosen value
		 while(allP1Num.contains(CpuNum) || allCpuNum.contains(CpuNum)
			   || allCpuNum.contains(allP1Num)){
			 r = new Random();
        	 CpuNum = r.nextInt(9)+1;
             
             //Ensure that Cpu does not overwrite Player 1
             while(allP1Num.contains(CpuNum) || allCpuNum.contains(CpuNum)){
            	 r = new Random();
            	 CpuNum = r.nextInt(9)+1;
     			
         }
		 }
		System.out.println("Cpu's turn!  chosen position: " +CpuNum);
		
		//Inputing values into the lists/Arrays by the CPU
		PcMove.insert(board, CpuNum, 'O');
		PcMove.display(board);	
		allCpuNum.add(CpuNum);
		UserMove.checkWinner();
		System.out.println(allCpuNum);
		}
	
		}


	
	}
	