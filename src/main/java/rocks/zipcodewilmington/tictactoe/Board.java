package rocks.zipcodewilmington.tictactoe;

import java.util.ArrayList;

/**
 * @author leon on 6/22/18.
 */
public class Board {

    private Character[][] board;

    public Board(Character[][] matrix) {
        // board/matrix initialized correctly/incorrectly?
        board = matrix;
    }

    public Boolean isInFavorOfX() {
        //call getWinner to check state
        //return true if 'X' wins
        return getWinner().equals("X");
    }

    public Boolean isInFavorOfO() {
        //call getWinner to check state
        //return true if 'O' wins
        return getWinner().equals("O");
    }

    public Boolean isTie() {
        //call getWinner to check state
        //return true if the return from getWinner is "tie"
        return getWinner().equals("");
    }

    public String getWinner() {
        //iterate across rows and columns to check if 'X' or 'O' have won
        //compound && boolean check to verify a win
        //'i' will mark the row starting point, going to the next one underneath for each iteration
        //Check rows, columns, and diagonal
        //Separate methods for directional checks?
        //Return string "X", "O", or "tie" based on results
        if(checkRow().equals("X") || checkColumn().equals("X") || checkDiagonal().equals("X")){
            return "X";
        }
        else if(checkRow().equals("O") || checkColumn().equals("O") || checkDiagonal().equals("O")){
            return "O";
        }
        else{
            return "";
        }

    }

    public String checkRow(){
        //for loop
        //string builder append string check
        StringBuilder row = new StringBuilder();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                row.append(board[i][j]);
            }
            if(row.toString().equals("XXX")){
                return "X";
            }
            else if(row.toString().equals("OOO")){
                return "O";
            }
            row.setLength(0);
        }
        return "";
    }

    public String checkColumn(){
        //for loop
        //string builder append string check
        StringBuilder column = new StringBuilder();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                column.append(board[j][i]);
            }
            if(column.toString().equals("XXX")){
                return "X";
            }
            else if(column.toString().equals("OOO")){
                return "O";
            }
            column.setLength(0);
        }
        return "";
    }

    public String checkDiagonal(){
        //hard code if statement?
        //StringBuilder diagonal = new StringBuilder();
        ArrayList<Character> diagonal1 = new ArrayList<Character>();
        diagonal1.add(board[0][0]);
        diagonal1.add(board[1][1]);
        diagonal1.add(board[2][2]);

        if(diagonal1.toString().equals("XXX")){
            return "X";
        }
        else if(diagonal1.toString().equals("OOO")){
            return "O";
        }

        ArrayList<Character> diagonal2 = new ArrayList<Character>();
        diagonal2.add(board[0][2]);
        diagonal2.add(board[1][1]);
        diagonal2.add(board[2][0]);

        if(diagonal2.toString().equals("XXX")){
            return "X";
        }
        else if(diagonal2.toString().equals("OOO")){
            return "O";
        }

        return "";
    }

}
