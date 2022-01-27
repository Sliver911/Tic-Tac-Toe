package program;

public class WinningCondition {
    
    static String[] board;
    
    
  
    static String winningCondition()
    {
        for (int i = 0; i < 9; i++) {
            String line = "";
  
            switch (i) {
            case 1:
                line = board[0] + board[1] + board[2]; //Top Row
                break;
            case 2:
                line = board[3] + board[4] + board[5]; //Middle Row
                break;
            case 3:
                line = board[6] + board[7] + board[8]; //Bottom Row
                break;
            case 4:
                line = board[0] + board[3] + board[6]; //1st Column
                break;
            case 5:
                line = board[1] + board[4] + board[7]; //2nd Column
                break;
            case 6:
                line = board[2] + board[5] + board[8]; //3rd Column
                break;
            case 7:
                line = board[0] + board[4] + board[8]; //1st Cross
                break;
            case 8:
                line = board[2] + board[4] + board[6]; //2nd Cross
                break;
            }
            //Player wins
            if (line.equals("XXX")) {
                return "X";
            }
              
            //Cpu wins
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "draw";
            }
        }