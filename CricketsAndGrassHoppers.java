import java.util.Scanner;

public class CricketsAndGrassHoppers {

    private static int PLAYER = 1;

    public static int promptNumberReadLine(Scanner s, String prompt, int max) {

        while(true) {

            if (s.hasNextInt()) {

                int num = s.nextInt();
                s.nextLine();

                if(num >= 1 && num <= max){

                    return num;
                }

            } else {

                s.nextLine();

            }

            System.out.println("That was not a valid number! Please try again.");
            System.out.print(prompt);
        }
    }

    public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle){

        int[] gameBoard = new int[(piecesPerPlayer * 2) + spacesInMiddle];

        for(int i = 0; i < gameBoard.length; i++){

            if(i < piecesPerPlayer){

                gameBoard[i]=1;
            }

            if(i > piecesPerPlayer + spacesInMiddle - 1){
                gameBoard[i] = 2;
            }
        }

        return gameBoard;
    }

    public static String boardToString(int[] board){

       String gameBoard = "";

        for(int i = 0; i < board.length; i++){

            if(board[i] == 1){

                gameBoard += "C";

            } else if(board[i] == 0){

                gameBoard += ".";

            } else {

                gameBoard += "G";
            }
        }

        return gameBoard;
    }

    public static boolean canMove(int[] board, int player){

        for(int i = 0; i < board.length; i++) {

            if (player == 1) {

                if(i < board.length - 1 && board[i]==player && board[i+1]==0){

                  return true;

                } else if( i < board.length - 2 && board[i]==player && board[i+1]==2 && board[i+2]==0){

                    return true;
                }

            }else if(player == 2){

                if(i > 0 && board[i] == player && board[i-1]==0){

                    return true;
                }

                if(i > 1 &&board[i]==player && board[i-1]==1 && board[i-2]==0){
                    return true;
                }
            }
        }

        return false;

    }

    //Use this boolean to update player 1 to player 2 or player 2 to player 1.
    public static boolean move(int[] board, int player, int position) {

        position = position - 1;

        if(position > board.length || position < 0){
            return false;
        }

        if(player == 1){
           if(position + 1 < board.length && board[position]==player && board[position+1]==0){

                board[position+1]=player;
                board[position]=0;

                return true;

            }else if(position + 2 < board.length && board[position] == player && board[position + 1] == 2 &&
                   board[position + 2] == 0){

                board[position + 2 ]= player;
                board[position] = 0;

                return true;

            }else{

                return false;
            }

        }else if(player == 2){

           if(position - 1 > -1 && board[position] == player && board[position - 1]==0){

                board[position] = 0;
                board[position-1]=player;

                return true;

            }else if(position - 2 > -1 && board[position] == player && board[position - 1] == 1 &&
                   board[position - 2] == 0){

                board[position]=0;
                board[position-2]=player;

                return true;

            }else{

                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String numPiecesPrompt = "Please enter the number of pieces for each player (1-10): ";
        String numSpaceInMiddle = "Please enter the number of spaces in the middle (1-9): ";
        System.out.print(numPiecesPrompt);
        int numOfPieces = promptNumberReadLine(input, numPiecesPrompt, 10);
        System.out.print(numSpaceInMiddle);
        int numOfSpaceInMiddle = promptNumberReadLine(input, numSpaceInMiddle, 9);
        int[] UPDATED_BOARD = createBoard(numOfPieces, numOfSpaceInMiddle);
        String cricketPrompt = "Crickets, please enter your move (1-" + UPDATED_BOARD.length + "): ";
        String grassHopperPrompt = "Grasshoppers, please enter your move (1-" + UPDATED_BOARD.length + "): ";
        String validSpacePrompt = "That space does not contain a piece you can move! Please try again.";

        System.out.println(boardToString(UPDATED_BOARD));

        while (true) {

            if (PLAYER == 1 && canMove(UPDATED_BOARD, PLAYER)) {

                System.out.print(cricketPrompt);

                int position = promptNumberReadLine(input, cricketPrompt, UPDATED_BOARD.length);

                if (move(UPDATED_BOARD, PLAYER, position)){
                    PLAYER = 2;

                } else if(!move(UPDATED_BOARD, PLAYER,position)){

                    System.out.println(validSpacePrompt);
                    continue;

                } if(!canMove(UPDATED_BOARD, PLAYER)){
                    break;
                }

            } else if (PLAYER == 2 && canMove(UPDATED_BOARD, PLAYER)) {

                System.out.print(grassHopperPrompt);

                int position = promptNumberReadLine(input, grassHopperPrompt, UPDATED_BOARD.length);

                if (move(UPDATED_BOARD, PLAYER, position)){

                    PLAYER = 1;

                }else if(!move(UPDATED_BOARD, PLAYER,position)){

                    System.out.println(validSpacePrompt);

                    continue;
                }

                if(!canMove(UPDATED_BOARD, PLAYER)){

                   break;
                }
            }

            System.out.println(boardToString(UPDATED_BOARD));
        }

        if(PLAYER == 2){

            System.out.println("Crickets win!");

        }else{

            System.out.println("Grasshoppers win!");

        }


    }
}
